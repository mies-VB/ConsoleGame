import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner INPUT = new Scanner(System.in);
        boolean Death = false;
        /*String phrase = INPUT.nextLine();
        System.out.println(stringParse(phrase, "lax"));*/
        System.out.println("You return to consciousness to the sound of blaring warning sirens and lights on your control panel.\n");
        Thread.sleep(500);
        System.out.println("The crunching noise of busted rotors above you is deafening.\n");
        Thread.sleep(1000);
        System.out.println("The memories come flooding back. You were guiding a scenic helicopter tour\n" +
                "of the gopher valley when a massive hoard of flying gophers comes and ambushes your helicopter.\n" +
                "Some of the flying gophers ended up being swallowed by the helicopter's rotors, destroying the gears\n" +
                "and rendering the propellers useless. The gophers who didn't die smashed through the side door of the helicopter and\n" +
                "brutally murdered all of your passengers. At this point, the helicopter had become engulfed in flames,\n" +
                "so the flying gophers were unable to continue their operation. This left you the sole survivor. \n" +
                "Knocked out from the shock of engine explosions and propellers failing, but alive.");
        Thread.sleep(1000);
        System.out.println("\nTime is of the essence! You must act quick and escape the helicopter. ");
        boolean[] Inventory = new boolean[6];
        Inventory[0] = false;//Parachute
        Inventory[1] = false;//Survival Supplies
        Inventory[2] = false;//Wood
        Inventory[3] = false;//Spear
        Inventory[4] = false;//Gophers
        Inventory[5] = false;//Comms Device
        boolean Crash = true;
        for (int i = 0; i < 6; i++) {
            System.out.println("\n\nYou look around and see some possible things that can help you escape:\n" +
                    "   - Use the helicopter controls to land safely\n" +
                    "   - Jump out\n" +
                    "   - Grab parachute backpack\n" +
                    "   - Grab survival supplies");
            System.out.print("\n>   ");
            String heliEscape = INPUT.nextLine();
            if (heliEscape.contains("control")) {//Play with helicopter controls
                System.out.println("\nThe controls of the helicopter no longer work. There is no way to land it safely.");
            } else if (heliEscape.contains("jump")) {//jump from heli
                if (Inventory[0]) {
                    System.out.println("\nYou jump from the helicopter. Your altitude is much lower than you had expected, but you must make it work.\n" +
                            "Once you're clear from the helicopter, you release your parachute to drift slowly to the ground.");
                    Thread.sleep(1000);
                    Crash = false;
                    i = 6;
                } else {
                    Death = true;
                    Crash = false;
                    System.out.println("\nYou jump out of the helicopter but have no parachute to slow your fall. You fall to your death and the gophers eat your corpse.\n");
                    i = 6;
                }
            } else if (heliEscape.contains("para")) {//grab the parachute backpack
                if (!Inventory[0]) {
                    System.out.println("\nYou grab the parachute backpack and put it on.\n");
                    Inventory[0] = true;
                } else {
                    System.out.println("\nYou've already grabbed the parachute backpack.\n");
                }
            } else if (heliEscape.contains("surviv")) {//Grab the survival supplies
                if (!Inventory[1]) {
                    System.out.println("\nYou grab the survival supplies and stash them on your person.\n");
                    Inventory[1] = true;
                } else {
                    System.out.println("\nYou've already grabbed the survival supplies.\n");
                }
            } else {
                System.out.println("\nSorry, please phrase your request differently");
                Thread.sleep(500);
                i--;
            }
        }
        if (Crash) {
            System.out.println("\n\nYou were too indecisive, and the helicopter crashed before you made your escape.\n" +
                    "The impact of the crash notified the gophers of your demise, and they had a cult bonfire dance around you and the helicopter's burning remains");
            Death = true;
        }
        if (Death) {
            DeathString();
        }
        boolean Landing = getRandomBoolean();
        String Area;
        if (Landing) {
            Area = "Forest";
            System.out.println("\n\nThe ground comes into view and all you see is trees. In the distance you spot an open plain, and also a tall mountain. There is no open spot of land that you can reach before hitting the ground.\n" +
                    "You land in the trees with your parachute entangled in the branches. The parachute keeps you from hitting the ground, but you're stuck. \n" +
                    "You wrestle the parachute pack off, and fall to the ground.\n\n");
            Thread.sleep(1000);

        } else{
            Area = "Plains";
            System.out.println("\n\nThe ground comes into view and below you see a lush grass blowing in the wind. This scenery irks you, as there is no wind  that should be blowing the grass in such a manner.\n" +
                    " As you near the ground, you notice the grass is moving because of the hoards of gophers running through this tall grass. \n" +
                    "You hit the ground, and immediately those vicious beasts jump onto you and begin biting and clawing at your flesh.\n" +
                    "Momentarily stalled by taking off your parachute pack, you run away from the gopher congregation into a safer are of the plains. \n" +
                    "After catching your breath you take in your surroundings and spot a forest and a large mountain in the distance.\n" +
                    "Suddenly, a sharp pain courses through your body. The gophers have left deep gashes in your flesh that are bleeding profusely.");
            Thread.sleep(1000);
            if (Inventory[1]) {
                System.out.println("\nYou search through the survival supplies you took with you, and mend your wounds to prevent you from bleeding out.");
                Thread.sleep(500);

            } else {
                System.out.println("\nThe deep gashes the gophers have left remain untreated because you didn't bring any medical supplies. \n" +
                        "You've lost too much blood to move anymore, and the gophers have located you. \n" +
                        "You die a painful death being eaten alive.");
                Thread.sleep(500);
                DeathString();
            }
        }
        boolean Victory = false;
        boolean Cooked = false;
        boolean Camp = false;
        boolean Sleep = false;
        boolean notHungry = false;
        while (!Victory) {
            if (Area.equals("Forest")) {
                if (!Inventory[2]) {
                    System.out.println("- Collect wood");
                } else {
                    if (!Inventory[3]) {
                        System.out.println("- Make spear");
                    }
                    if (!Camp) {
                        System.out.println("- Set up camp");
                    }
                }
                if (Inventory[4]) {
                    if (!Cooked) {
                        System.out.println("- Cook gophers");
                    }
                    System.out.println("- Eat gophers");
                }
                System.out.println("- Sleep");
                System.out.println("- Search for Plains");
                System.out.print("\n>   ");
                String forestActivities = INPUT.nextLine();
                if (forestActivities.contains("wood")) {
                    if (!Inventory[2]) {
                        System.out.println("\nYou walk out into the forest and collect wood from the trees around you.\n");
                        Inventory[2] = true;
                    } else {
                        System.out.println("\nYou've already collected enough wood.\n");
                    }
                } else if (forestActivities.contains("spear")) {
                    if (Inventory[3]) {
                        System.out.println("\nYou already have a spear.\n");
                    } else {
                        if (Inventory[1]) {
                            System.out.println("\nYou strap a knife that was in your survival kit to the end of a sturdy, straight branch to make a spear.\n");
                            Inventory[3] = true;
                        } else {
                            System.out.println("\nYou don't have a knife to strap onto the end of your longs stick. Wow! Congrats! Kudos! You found a useless stick! You throw the stick in with the rest of your wood pile.\n");
                        }
                    }
                } else if (forestActivities.contains("camp")) {
                    if (!Camp) {
                        System.out.println("\nYou used your wood to make a fire, and construct a small shelter for you to sleep under for the night.\n");
                        Inventory[2] = false;
                        Camp = true;
                    } else {
                        System.out.println("\nYou've already set up camp.\n");
                    }
                } else if (forestActivities.contains("sleep")) {
                    System.out.println("\nYou doze off, the world around you fades away into a blissful dreamworld.\n");
                    Sleep = true;
                    Thread.sleep(1000);
                    if (!Camp) {
                        System.out.println("\nThe night is cold and you have nothing to warm you. You freeze to death this lonely night.\n");
                        DeathString();
                    }
                } else if (forestActivities.contains("plain")) {
                    System.out.println("\nYou wander off through the forest to find the plains.");
                    Area = "Plains";
                } else if (forestActivities.contains("eat")) {
                    if (Cooked) {
                        System.out.println("\nYou eat the gophers you cooked and regain energy.\n");
                        Inventory[4] = false;
                        Cooked = false;
                        notHungry = true;
                    } else if (!Inventory[4]) {
                        System.out.println("You do not have any gophers.");
                    } else {
                        System.out.println("\nThe gophers were not safe to eat raw due to the parasites and viruses within their flesh. You contract severe food poisoning and die.\n");
                        DeathString();
                    }
                } else if (forestActivities.contains("cook")) {
                    if (Camp && (!Cooked)) {
                        if (Inventory[4]) {
                            System.out.println("\nYou cook the gophers above the fire in camp.\n");
                            Cooked = true;
                        } else {
                            System.out.println("You do not have any gophers to cook.");
                        }

                    } else if (!Camp) {
                        if (!Inventory[4]) {
                            System.out.println("\nYou do not have any gophers to cook.\n");
                        } else {
                            System.out.println("\nYou haven't set up a camp with a fire to cook your bounty.\n");
                        }
                    } else{
                        System.out.println("\nYour gophers have already been cooked.\n");
                    }
                }
                else {
                    System.out.println("\nSorry, please phrase your request differently");
                    Thread.sleep(500);}
            }
            if (Area.equals("Plains")) {
                if (!Inventory[4]) {
                    System.out.println("- Hunt gophers");
                } else {
                    System.out.println("- Eat gophers");
                }
                System.out.println("- Sleep");
                System.out.println("- Walk to forest");
                System.out.println("- Walk to mountain");
                System.out.print("\n>   ");
                String plainsActivities = INPUT.nextLine();
                if (plainsActivities.contains("hunt")) {
                    if (Inventory[3]) {
                        System.out.println("\nYou walk towards the eerily swaying grasses, and from a distance kill some gophers with your spear.\n");
                        Inventory[4] = true;
                    } else {
                        System.out.println("\nYou do not dare approach the gophers. You require a weapon that allows you to kill them from a distance somehow.\n");
                    }
                }
                else if (plainsActivities.contains("eat")) {
                    if (Cooked) {
                        System.out.println("\nYou eat the gophers you cooked and regain energy.\n");
                        Inventory[4] = false;
                        Cooked = false;
                        notHungry = true;
                    } else if (!Inventory[4]) {
                        System.out.println("You do not have any gophers.");
                    } else {
                        System.out.println("\nThe gophers were not safe to eat raw due to the parasites and viruses within their flesh. You contract severe food poisoning and die.\n");
                        DeathString();
                    }
                }
                else if(plainsActivities.contains("sleep")){
                    System.out.println("\nThe night is cold and you have nothing to warm you. You freeze to death this lonely night.\n");
                    DeathString();
                }
                else if (plainsActivities.contains("forest")) {
                    System.out.println("\nYou walk towards the treeline and make your way into the forest.\n");
                    Area = "Forest";
                }
                else if (plainsActivities.contains("mount")) {
                    System.out.println("\nYou walk towards the base of the mountain.\n");
                    Area = "Mountain";
                }
                else {
                    System.out.println("\nSorry, please phrase your request differently");
                    Thread.sleep(500);}
            }
            if (Area.equals("Mountain")) {
                if (!Inventory[5]) {
                    System.out.println("- Find Helicopter ruins");
                }
                System.out.println("- Climb mountain");
                System.out.println("- Walk to plains");
                System.out.println("- Walk to forest");
                System.out.print("\n>   ");
                String mountainActivities = INPUT.nextLine();
                if (mountainActivities.contains("heli")) {
                    if (!Inventory[5]) {
                        System.out.println("\nYou spot a plume of smoke rising above the treeline in the distance beside the mountain you are approaching. " +
                                "You decide to go investigate.\n");
                        Thread.sleep(1000);
                        System.out.println("\nYou finally reach the source of the smoke. It is your helicopter that was so brutally attacked by a flying gopher squadron.\n" +
                                "After staring into the wreckage for a few minutes, you notice your communications device laying within the ruins, miraculously, unscathed.\n" +
                                "You precariously hop around the scalding hot metal shards, pick up the communications device, and clip it onto your belt.\n" +
                                "If you can just get to the top of the mountain, you can send out a distress signal and someone may actually receive it.\n");
                        Inventory[5] = true;
                    } else {
                        System.out.println("\nYou've already looked through the ruins and there was nothing else intact other than the comms device you picked up.\n");
                    }
                }
                else if (mountainActivities.contains("climb")) {
                    if (!Sleep) {
                        System.out.println("\nYou are too tired to climb the mountain. Get some rest.\n");
                    } else {
                        System.out.println("\nYou begin your ascent up the mountain. It is a steep, difficult hike, at some points you are even forced to climb.\n");
                        Thread.sleep(1000);
                        if (!notHungry) {
                            System.out.println("\nMid-way up the mountain you are so hungry that you lose the ability to go any further. You become so distracted by \n" +
                                    "your stomach's calls for food that your foot placement becomes lazy and imprecise. You misstep, and the ground below you breaks away to a steep tumble down the mountain.\n" +
                                    "The tumble is hurtles your body into a colony of gophers who gladly feast upon you mangled body.\n");
                            DeathString();
                        } else {
                            notHungry = false;
                            Sleep = false;
                            System.out.println("\nAfter a long, tiresome ascent, you reach the summit.\n");
                            if (!Inventory[5]) {
                                System.out.println("\nThere is no civilization that you can see from this vantage point. Nice view though.\n" +
                                        "You walk back down to your camp in the forest.\n");
                                Area = "Forest";
                                Thread.sleep(2000);
                            } else {
                                System.out.print("\nYou unclip your comms device from your belt.\n" +
                                        "(Which Direction would you like to send a distress signal in?)\n" +
                                        "   - North\n" +
                                        "   - South\n" +
                                        "   - West\n" +
                                        "   - East\n\n" +
                                        ">  ");
                                String signalDirection = INPUT.nextLine();
                                System.out.println("\nYou face " + signalDirection + " and send out a distress call, hoping someone may be receive it\n");
                                Thread.sleep(500);
                                boolean Saved = Random();
                                if (Saved) {
                                    System.out.println("A crackling noise comes out of the device's speaker. After a moment, you hear someone speak.\n" +
                                            "You describe your situation to the person receiving the call, and they dispatch a rescue team to bring you back to salvation.\n" );
                                    Thread.sleep(700);
                                    System.out.println("After what felt like ages, you see a rescue helicopter approaching your location. You begin waving at them to notify the pilots of\n" +
                                            "your location. You are overjoyed, because finally, you may leave this gopher hell.\n" +
                                            "Then out of nowhere, a flock of small birds begins flying towards the rescue helicopter. Upon closer inspection you are horrified.\n" +
                                            "It is yet another group of flying gophers ready to attack. Your spirits drop as you watch the helicopter go up in flames and drop into\n" +
                                            "the Gopher Valley. The gophers were aware of your waving, and begin their approach. These gophers's thirst for blood is insatiable.\n" +
                                            "You are frozen in horror. The gophers arrive and sink their claws and teeth into your flesh. You are eaten alive.\n");
                                    Thread.sleep(1000);
                                    System.out.println("\nIn the end your efforts to escape were futile, and the hell of gohper valley was impossible to escape.\n");
                                    Thread.sleep(3000);
                                    Victory = true;
                                }
                                else{
                                    System.out.println("Your comms device remained silent, and after that unsuccessful attempt to reach someone, you made your way  down the mountain and back to the camp you set up in the forest.\n\n");
                                    Area = "Forest";
                                    Thread.sleep(2000);
                                }

                            }
                        }
                    }
                }
                else if (mountainActivities.contains("forest")) {
                    System.out.println("\nYou walk towards the treeline and make your way into the forest.\n");
                    Area = "Forest";
                }
                else if (mountainActivities.contains("plain")) {
                    System.out.println("\nYou wander off through the forest to find the plains.");
                    Area = "Plains";}
                else {
                    System.out.println("\nSorry, please phrase your request differently");
                    Thread.sleep(500);}
            }
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nThe End.\n\n\n\n\n\nThank you for playing.");
    }




static boolean Random(){
        boolean signalReceived;
Random random = new Random();
int x = random.nextInt(3)+1;
    signalReceived = x == 3;
return  signalReceived;
}

    static boolean getRandomBoolean(){
        return Math.random() < 0.5;}
    static void DeathString(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\nYou died. The gophers have won.");
        System.exit(69);

    }
/*
    public static boolean stringParse(String phrase, String key){

        //Loop through the letters of phrase
        for (int i = 0; i < phrase.length() ; i++) {

            boolean foundIt = true;
            //Loop through the letters of keyword
            for (int j = 0; j < key.length(); j++) {


                //check if the letters are the same.
                if( phrase.charAt(i+j)  == key.charAt(j) ){

                }
                else{
                    //If they are different, break this loop
                    foundIt = false;
                    break;

                }




                //End loop
            }

            //If the loop finishes without breaking: return true
            if(foundIt){
                return true;
            }
            //End Loop
        }
        //you didn't find it, return false.
        return false;
    }

*/
}