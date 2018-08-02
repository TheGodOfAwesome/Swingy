# **************************************************************************** #
#                                                                              #
#                                                         :::      ::::::::    #
#    README.md                                          :+:      :+:    :+:    #
#                                                     +:+ +:+         +:+      #
#    By: kmuvezwa <marvin@42.fr>                    +#+  +:+       +#+         #
#                                                 +#+#+#+#+#+   +#+            #
#    Created: 2018/08/02 13:20:36 by kmuvezwa          #+#    #+#              #
#    Updated: 2018/08/02 13:25:41 by kmuvezwa         ###   ########.fr        #
#                                                                              #
# **************************************************************************** #


##Mandatory part  
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
depending on the villain’s strenght.  
Leveling up is based on the following formula level*1000+(level − 1)2*450. So the
necessary experience to level up will follow this pattern:  
• Level 1 - 1000 XP  
• Level 2 - 2450 XP  
• Level 3 - 4800 XP  
• Level 4 - 8050 XP  
• Level 5 - 12200 XP
  
##V.2 Features  
The game can be launched in 2 modes as described below.  
$java -jar swingy.jar console  
$java -jar swingy.jar gui  
A user’s heroes and their state will be preserved, when the user exits the game, in a
text file. When starting the game, your program will load the heroes from this file.    

##V.3 Validation  
You will need to integrate a third party library in your project in order to provide annotation
based validation. We highly recommend that you use a library that implements
the javax.validation specification.
You will not allow any abnormal user input to disrupt the game behaviour. Validation
failure will be highlighted to the user.  

##V.4 Bonus part
Bonus points will be given if:  
• You persist the user’s heroes in a relational database, instead of a text file.  
• You can switch between console view and GUI view at runtime, without closing the
game.  