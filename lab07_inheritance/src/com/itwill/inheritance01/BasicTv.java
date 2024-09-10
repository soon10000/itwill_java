package com.itwill.inheritance01;

// extends object는 생략 가능
public class BasicTv {
	//상수 정의
	public static final int MIN_CHANNEL = 0;
	public static final int MAX_CHANNEL = 2;
	public static final int MIN_VOLUME = 0;
	public static final int MAX_VOLUME = 2;
	
	
	// field
	private boolean powerOn; // 현재 전원 상태(true -> ON, false -> OFF)
	private int channel; // 현재 채널 번호
	private int volume; // 음량
	
	// constructor
	public BasicTv() {}
	public BasicTv(boolean powerOnOff, int channel, int volume) {
		this.powerOn = powerOn;
		this.channel = channel;
		this.volume = volume;
	}
	
	
	//method
	
	public boolean isPowerOn() {
		return powerOn;
	}
	public void setPowerOn(boolean powerOn) {
		this.powerOn = powerOn;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	
	/**
	 * TV가 켜져 있으면 끄고, 반대로, TV가 꺼져 있으면 켬
	 * powerOn의 값이 true이면 false 변경, powerOn의 값이 false이면 true로 변경
	 * @return powerOn
	 */
	public boolean powerOnOff() {
		if (powerOn) {
			powerOn = false;
			System.out.println("TV OFF");
		} else {
			powerOn = true;
			System.out.println("TV ON");
		}
		return powerOn;
	}
	
	
	/**
	 * channelUp. 현재 채널의 값을 1증가
	 * 만약 현재 채널 값이 채널의 최대값(MAX_CHANNEL)인 경우, 채널의 최소값(MIN_CHANNEL)으로 바꿔준다.
	 * @return 바뀐 현재 채널 값
	 */
	public int channelUp() {
		if (powerOn) {
			if (channel < MAX_CHANNEL) {
				channel++;
			} else {
				channel = MIN_CHANNEL;
			}
			System.out.println("CH >> " + channel);
		}
		return channel;
	}
	
		
	
	
	
	
	
	/**
	 * channelDown. 현재 채널의 값을 1감소
	 * 만약 현재 채널 값이 채널의 최소값(MIN_CHANNEL)인 경우, 채널의 최대값(MAX_CHANNEL)으로 바꿔준다.
	 * @return 바뀐 현재 채널 값
	 */
	public int channelDown() {
		if (powerOn) {
			if (channel > MIN_CHANNEL) {
				channel--;
			} else {
				channel = MAX_CHANNEL;
			}
			System.out.println("CH >> " + channel);
		}
		return channel;
	}
	
		
	
	/**
	 * volumeUp. 현재 볼륨의 값을 1증가
	 * 만약 현재 볼륨 값이 볼륨의 최대값(MAX_VOLUME)인 경우, 음량을 변경하지 않는다.
	 * @return 바뀐 현재 음량의 값
	 */
	public int volumeUp() {
		if (powerOn) {
			if (volume < MAX_VOLUME) {
				volume++;
			}
			System.out.println("볼륨 >> " + volume);
		}
		return volume;
	}
	
	
	
	
	
	/**
	 * volumeDown. 현재 볼륨의 값을 1감소
	 * 만약 현재 볼륨 값이 볼륨의 최소값(MIN_VOLUME)인 경우, 음량을 변경하지 않는다.
	 * @return 바뀐 현재 음량의 값
	 */
	public int volumeDown() {
		if (powerOn) {
			if (volume > MIN_VOLUME) {
				volume--;
			}
			System.out.println("볼륨 >> " + volume);
		}
		return volume;
	}
	
	
	
	
	

}
