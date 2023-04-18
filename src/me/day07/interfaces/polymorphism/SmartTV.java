package me.day07.interfaces.polymorphism;

public class SmartTV extends Electronic implements SmartPhoneControllable {
    private int volume;
    private boolean isMute;

    @Override
    public void on() {
        System.out.println(SmartTV.class.getName() + " on");
    }

    @Override
    public void off() {
        System.out.println(SmartTV.class.getName() + " off");
    }

    @Override
    public void setVolume(int volume) {
        if (volume >= SmartPhoneControllable.MIN_VOLUME && volume <= SmartPhoneControllable.MAX_VOLUME) {
            this.volume = volume;
        } else {
            System.out.println("Can't Set That Volume ... Too High or Lower");
        }
        System.out.println(this.volume + " Volume ... ");
    }

    @Override
    public void toggleMute() {
        isMute = !isMute;
        System.out.println((isMute  ? "Mute" : "Unmute") + " Status ... ");
    }

    @Override
    public void changeBattery() {
        System.out.println(SmartTV.class.getName() + " Change Battery...");
    }

    @Override
    public void listenVoice() {
        System.out.println(SmartTV.class.getName() + " Listening Your Voice...");
    }
}
