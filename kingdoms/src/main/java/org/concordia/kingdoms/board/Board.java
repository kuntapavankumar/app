package org.concordia.kingdoms.board;

import java.util.List;

import org.concordia.kingdoms.Player;
import org.concordia.kingdoms.board.factory.CoinBank;
import org.concordia.kingdoms.board.factory.TileBank;
import org.concordia.kingdoms.board.ui.Console;
import org.concordia.kingdoms.board.ui.Presentable;
import org.concordia.kingdoms.exceptions.GameRuleException;

import com.google.common.collect.Lists;

public class Board {

	private Entry[][] entries;

	private TileBank tileBank;

	private CoinBank coinBank;

	private List<Player> players;

	private Presentable presentable;

	public static final int MAX_ROWS = 5;

	public static final int MAX_COLUMNS = 6;

	private int componentsOnBoard;

	public Board(final Entry[][] entries) {
		this.entries = entries;
		this.tileBank = null;
		this.coinBank = null;
		this.players = Lists.newArrayList();
		this.presentable = new Console(entries);
		this.componentsOnBoard = 0;
	}

	public void putComponent(Component component, int row, int column)
			throws GameRuleException {
		if (!isValidPosition(row, column)) {
			throw new GameRuleException("Invalid positon(" + row + "," + column
					+ ")");
		}
		if (!this.getEntries()[row][column].isEmpty()) {
			throw new GameRuleException("No Space available");
		}
		this.getEntries()[row][column].setComponent(component);
		this.componentsOnBoard++;
	}

	public boolean isValidPosition(int row, int column) {
		return row >= 0 && row < MAX_ROWS && column >= 0
				&& column < MAX_COLUMNS;
	}

	public void display() {
		this.presentable.present();
	}

	public Entry[][] getEntries() {
		return this.entries;
	}

	public TileBank getTileBank() {
		return this.tileBank;
	}

	public void setTileBank(TileBank tileBank) {
		this.tileBank = tileBank;
	}

	public CoinBank getCoinBank() {
		return this.coinBank;
	}

	public void setCoinBank(CoinBank coinBank) {
		this.coinBank = coinBank;
	}

	public List<Player> getPlayers() {
		return this.players;
	}

	public void setPlayers(final List<Player> players) {
		this.players = players;
	}

	public boolean hasAnyEmptySpace() {
		return this.componentsOnBoard == MAX_ROWS * MAX_COLUMNS;
	}
}
