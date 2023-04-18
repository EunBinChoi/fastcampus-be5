package me.day07.interfaces.polymorphism;

public class SmartRefrig extends Electronic implements SmartPhoneRefrigControllable {
    private int volume;
    private boolean isMute;

     private String[] groceries = new String[] {"삼겹살", "우유", "무쌈", "깻잎"};

    @Override
    public void on() {
        System.out.println(SmartRefrig.class.getName() + " on");
    }

    @Override
    public void off() {
        System.out.println(SmartRefrig.class.getName() + " off");
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
        System.out.println(SmartRefrig.class.getName() + " Change Battery...");
    }

    @Override
    public void listenVoice() {
        System.out.println(SmartRefrig.class.getName() + " Listening Your Voice...");
    }

    @Override
    public void showGroceries() {
        for (String grocery: groceries) {
            System.out.println(grocery);
        }
    }
}
