/** 
 * Copyright [2013] Antonio J. Iniesta
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * 
 * File created: 26/05/2013 at 01:31:11 by antonio
 */
package com.iniesta.chronometer.data;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author antonio
 *
 */
@Entity
public class Puzzle {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int puzzleID;
	@Column(unique=true, nullable=false, length = 20)
	private String name;
	@Column(nullable=true)
	private byte[] image;
	
	public Puzzle(){
		super();
	}

	/**
	 * @param puzzleID
	 * @param name
	 * @param image
	 */
	public Puzzle(String name, byte[] image) {
		super();
		this.name = name;
		this.image = image;
	}

	/**
	 * @return the puzzleID
	 */
	public int getPuzzleID() {
		return puzzleID;
	}

	/**
	 * @param puzzleID the puzzleID to set
	 */
	public void setPuzzleID(int puzzleID) {
		this.puzzleID = puzzleID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the image
	 */
	public byte[] getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(image);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + puzzleID;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Puzzle))
			return false;
		Puzzle other = (Puzzle) obj;
		if (!Arrays.equals(image, other.image))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (puzzleID != other.puzzleID)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Puzzle [puzzleID=" + puzzleID + ", name=" + name + ", image=" + Arrays.toString(image) + "]";
	}
}
