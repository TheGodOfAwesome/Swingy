# Swingy  

A minimalistic text-based and GUI RPG game applying the best
practices suited for this problem. 

• First phase for hardcore hipsters will be console based  
• Second phase for regular hipsters, will also have a simple GUI for taking user
input.  
• Model-View-Controller design pattern.  
• Automated build with Maven.  
• Annotation based user input validation.  
Clean design, that is easy to read, understand and change in case the requirements are modified. 

## Compile
To compile in cmd  
* Run:  
   -> mvn clean package 

From the src directory   

## References

### [Oracle's Java SE 7 Documentation](https://docs.oracle.com/javase/7/docs/api/)  
e.g. https://docs.oracle.com/javase/7/docs/api/java/io/BufferedReader.html

### [Oracle's Java SE 7 Tutorials](https://docs.oracle.com/javase/tutorial/essential/)  
e.g. https://docs.oracle.com/javase/tutorial/essential/exceptions/finally.html

### [A pretty good programming resource](http://www.java2s.com/)
e.g. http://www.java2s.com/Code/JavaAPI/java.io/BufferedInputStream.htm

### [Intellij's Swing Gui Documetation](https://www.jetbrains.com/help/idea/creating-form-initialization-code.html)
e.g. https://www.jetbrains.com/help/idea/creating-form-initialization-code.html

### [Making a swing project using IntelliJ IDEA GUI builder with maven, Including executable jar](http://glxn.net/2010/08/17/making-a-swing-project-using-intellij-idea-and-gui-builder-with-maven-including-executable-jar)
e.g. http://glxn.net/2010/08/17/making-a-swing-project-using-intellij-idea-and-gui-builder-with-maven-including-executable-jar

### Links  
*   https://docs.oracle.com/javase/7/docs/api/java/io/BufferedReader.html  
*   https://docs.oracle.com/javase/tutorial/essential/exceptions/finally.html  
*   https://docs.oracle.com/javase/tutorial/java/data/manipstrings.html  
*   http://www.java2s.com/Code/JavaAPI/java.util/foreachloopforArrayList.htm  
*   https://www.geeksforgeeks.org/arrays-in-java/  
*   https://www.tutorialspoint.com/java/java_strings.htm  
*   https://www.tutorialspoint.com/java/java_inheritance.htm  
*   https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html
*   https://en.wikipedia.org/wiki/Class_diagram  
*   https://www.youtube.com/watch?v=wiQdrH2YpT4 Observer Design Pattern  
*   https://www.youtube.com/watch?v=ohL2HIBK1pg Observer Design Pattern  
*   https://www.youtube.com/watch?v=ub0DXaeV6hA&t=4s Factory Design Pattern  
*   https://www.youtube.com/watch?v=xbjAsdAK4xQ Abstract Factory Design Pattern  
*   https://www.jetbrains.com/help/idea/creating-form-initialization-code.html
*   http://glxn.net/2010/08/17/making-a-swing-project-using-intellij-idea-and-gui-builder-with-maven-including-executable-jar  


## Mandatory part  
You need  
• North  
• East  
• South  
• West  

When a map is generated, villains of varying power will be spread randomly over the
map. When a hero moves to a position occupied by a villain, the hero has 2 options:  
• Fight, which engages him in a battle with the villain  
• Run, which gives him a 50% chance of returning to the previous position. If the
odds aren’t on his side, he must fight the villain.  
You will need to simulate the battle between the hero and monster and present the
user the outcome of the battle. We leave it at you to find a nice simulation algorythm
that decides based on the hero and monster stats, who will win. You can include a small
"luck", component in the algo in order to make the game more entertaining.  
If a hero looses a battle, he dies and also looses the mission.  
If a hero wins a battle, he gains:  
• Experience points, based on the villain power. Of course, he will level up if he
reaches the next level experience.  
• An artifact, which he can keep or leave. Of course, winning a battle doesn’t guarantee
that an artefact will be droped and the quality of the artefact also varies
depending on the villain’s strength.  
Leveling up is based on the following formula level*1000+(level − 1)2*450. So the
necessary experience to level up will follow this pattern:
  
• Level 1 - 1000 XP  
• Level 2 - 2450 XP  
• Level 3 - 4800 XP  
• Level 4 - 8050 XP  
• Level 5 - 12200 XP
  
## V.2 Features  
The game can be launched in 2 modes as described below.  
$java -jar swingy.jar console  
$java -jar swingy.jar gui  
A user’s heroes and their state will be preserved, when the user exits the game, in a
text file. When starting the game, your program will load the heroes from this file.    

## V.3 Validation  
You will need to integrate a third party library in your project in order to provide annotation
based validation. We highly recommend that you use a library that implements
the javax.validation specification.
You will not allow any abnormal user input to disrupt the game behaviour. Validation
failure will be highlighted to the user.  

## V.4 Bonus part
Bonus points will be given if:  
• You persist the user’s heroes in a relational database, instead of a text file.  
• You can switch between console view and GUI view at runtime, without closing the
game.  