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
 * File created: 21/05/2013 at 21:17:23 by antonio
 */
package com.iniesta.chronometer.components;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

/**
 * @author antonio
 *
 */
public class ChronometerComponent extends HBox{

	private Label labelMillis;
	private Label labelSeconds;
	private Label labelMinutes;		
	private long timeCounter;
	private Timeline timeline;
	private Label semicolon1;
	private Label semicolon2;

	/**
	 * Chronometer with time 0
	 */
	public ChronometerComponent(){
		this(Duration.millis(0));
	}
	
	/**
	 * Chronometer with the given time
	 * @param duration
	 */
	public ChronometerComponent(Duration duration){		
		timeCounter = (long)duration.toMillis();
		setAlignment(Pos.CENTER);
		semicolon1 = new Label(":");
		semicolon2 = new Label(":");		
		labelMillis = new Label();
		labelSeconds = new Label();
		labelMinutes = new Label();
		updateLabels(timeCounter);
		getChildren().addAll(labelMinutes, semicolon1, labelSeconds, semicolon2, labelMillis);		
		timeline = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				updateLabels(timeCounter++);				
			}}));
		timeline.setCycleCount(Timeline.INDEFINITE);
	}
	
	/**
	 * Get the time represented in this chronometer
	 * @return
	 */
	public long getTime(){
		return timeCounter;
	}
	
	/**
	 * Get the time of the chronometer in Duration
	 * @return
	 */
	public Duration getDuration(){
		return Duration.millis(timeCounter);
	}
	
	/**
	 * Set the time of this chronometer
	 * @param time
	 */
	public void setTime(long time){
		this.timeCounter = time;
		updateLabels(timeCounter);
	}
	
	/**
	 * set the duration 
	 * @param time
	 */
	public void setDuration(Duration time){
		this.timeCounter = (long)time.toMillis();
		updateLabels(timeCounter);
	}
	
	/**
	 * Play the chronometer
	 */
	public void play(){
		timeline.play();
	}
	
	/**
	 * Stop the chronometer 
	 */
	public void stop(){
		timeline.stop();
	}
	
	/**
	 * Reset the chronometer
	 */
	public void reset(){
		stop();
		timeCounter = 0L;
	}
	/**
	 * Update the labels with the timeCounter, time in the chronometer in milliseconds
	 * @param timeCounter
	 */
	protected void updateLabels(long timeCounter) {
		long milliseconds = timeCounter%1000;
		long seconds = (timeCounter/1000)%60;
		long minutes = (timeCounter/60000)%60;
		String sMil = milliseconds<10?("00"+milliseconds):milliseconds<100?("0"+milliseconds):(""+milliseconds);
		String sSec = seconds<10?("0"+seconds):(""+seconds);
		String sMin = minutes<10?("0"+minutes):(""+minutes);
		labelMillis.setText(sMil);
		labelSeconds.setText(sSec);
		labelMinutes.setText(sMin);
	}

	public void setChronoStyle(String style) {
		labelMillis.setStyle(style);
		labelMinutes.setStyle(style);
		labelSeconds.setStyle(style);
		semicolon1.setStyle(style);
		semicolon2.setStyle(style);
	}

}
