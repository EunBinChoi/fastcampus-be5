package me.day07.interfaces.polymorphism;

public class GeneralTV extends Electronic implements RemoteControllable {
    private int volume;
    private boolean isMute;

    @Override
    public void on() {
        System.out.println(GeneralTV.class.getName() + " on");
    }

    @Override
    public void off() {
        System.out.println(GeneralTV.class.getName() + " off");
    }

    @Override
    public void setVolume(int volume) {
        if (volume >= RemoteControllable.MIN_VOLUME && volume <= RemoteControllable.MAX_VOLUME) {
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
        System.out.println(GeneralTV.class.getName() + " change battery...");
    }
}
