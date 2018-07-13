package com.kalah.ui.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import com.kalah.game.Game;
import com.kalah.utils.GameStatus;

@SuppressWarnings("deprecation")
@ManagedBean(name = "boardView")
@SessionScoped
public class BoardView {

	Game game = new Game();

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void playMove(ActionEvent actionEvent) {

		String color = (String) actionEvent.getComponent().getAttributes().get("color");
		String pitNumber = (String) actionEvent.getComponent().getAttributes().get("pitNumber");

		System.out.println("Playing Move: (" + color + ", " + pitNumber + ")");

		GameStatus status = game.playMove(color, Integer.parseInt(pitNumber));

		switch (status) {
		case GAME_OVER:
			calcuateFinalScore();
			addMessage("Game Over");
			break;

		case NEXT_PLAYER:
			addMessage("Next Move : " + (color.equals("blue") ? "orange" : "blue"));
			break;

		case PLAY_AGAIN:
			addMessage("Last stone landed in your own Kalah. Play Again");
			break;

		case EMPTY_PIT:
			addMessage("This pit is empty. Cannot be selected");
			break;

		case HOUSE_SELECTED:
			addMessage("Cannot select house. Play Again.");
			break;

		default:
			break;
		}
		RequestContext.getCurrentInstance().update("gameForm");
	}

	public void startGame(ActionEvent actionEvent) {
		game.init();
		addMessage("Game Started !!");
		RequestContext.getCurrentInstance().update("gameForm");
	}
	
	public void resetGame(ActionEvent actionEvent) {
		game.init();
		addMessage("Game Reset !!");
		RequestContext.getCurrentInstance().update("gameForm");
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void calcuateFinalScore() {
		this.game.calcuateFinalScore();
	}

}
