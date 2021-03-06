package org.concordia.kingdoms.tokens;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.concordia.kingdoms.board.Component;
import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

/**
 * This class represents different tiles used in the game
 * 
 * @author Team K
 * @since 1.0
 * @see TileType
 */
@AutoProperty
@XmlRootElement(name = "tile")
public class Tile implements Component, Serializable {

	private static final long serialVersionUID = 1L;

	@XmlAttribute
	private TileType type;

	@XmlElement
	private String name;

	@XmlElement
	private Integer value;

	/**
	 * default constructor
	 */
	private Tile() {
		this.type = null;
		this.name = null;
		this.value = null;
	}

	/**
	 * constructor for Tile
	 * 
	 * @param type
	 *            - It represents type of tile
	 * @param name
	 *            - It represents name of tile
	 * @param value
	 *            - It represents value of tile
	 */
	private Tile(TileType type, String name, Integer value) {
		this.type = type;
		this.name = name;
		this.value = value;
	}

	/**
	 * @return value associated with this Tile
	 */
	public Integer getValue() {
		return this.value;
	}

	/**
	 * @return name associated with this Tile
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return type associated with this Tile
	 */
	public TileType getType() {
		return this.type;
	}

	@Override
	public boolean equals(Object o) {
		return Pojomatic.equals(this, o);
	}

	@Override
	public int hashCode() {
		return Pojomatic.hashCode(this);
	}

	/**
	 * 
	 * @return full representation of the Tile including its type,name and value
	 *         using org.pojomatic.Pojomatic's way of format
	 */
	public String show() {
		return Pojomatic.toString(this);
	}

	/**
	 * @return A string representing Tile in a maximum of 10 string literal
	 */
	@Override
	public String toString() {
		return "T:" + this.getName().substring(0, 3) + ":" + this.getValue()
				+ ":" + this.getType().toString().charAt(0);
	}

	/**
	 * A factory method to create a new {@link Tile} using {@link TileType},name
	 * and a value.
	 * 
	 * @param type
	 *            {@link TileType}
	 * 
	 * @return A new {@link Tile}
	 */
	public static Tile newTile(TileType type, String name, Integer value) {
		return new Tile(type, name, value);
	}

}
