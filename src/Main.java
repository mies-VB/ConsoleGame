import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        /*Scanner INPUT = new Scanner(System.in);
        String phrase = INPUT.nextLine();
        System.out.println(stringParse(phrase, "lax"));*/
        System.out.println("You return to consciousness to the sound of blaring warning sirens and lights on your control panel.\n");
        Thread.sleep(500);
        System.out.println("The crunching noise of busted rotors above you is deafening.\n");
        Thread.sleep(1000);
        System.out.println("The memories come flooding back. You were guiding a scenic helicopter tour\n" +
                "of the gopher mountain range when a massive hoard of flying gophers comes and ambushes your helicopter.\n" +
                "Some of the flying gophers ended up being swallowed by the helicopter's rotors, destroying the gears\n" +
                "and rendering the propellors useless. The gophers who didn't die smashed through the side door of the helicopter and\n" +
                "brutally murdered all of your passengers. At this point, the helicopter had become engulfed in flames,\n" +
                "so the flying gophers were unable to continue their operation. This left you the sole survivor. \n" +
                "Knocked out from the shock of engine explosions and propellers failing, but alive.");
        Thread.sleep(1000);
        System.out.println("\nTime is of the essence! You must act quick and escape the helicopter. ");

        
        System.out.println("\n\nYou look around and see some possible things that can help you escape:\n" +
                "   - Use the helicopter controls to land safely\n" +
                "   - Jump out\n" +
                "   - Grab parachute backpack\n" +
                "   - Grab survival supplies");


    }

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


}