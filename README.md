# Mars-Exploration

The colonization of Mars has finally started. In order to avoid wasting billions of dollars worth of equipment in space, a lot of 
simulation exercises need to be done here on Earth. To fully dial in the Mars rovers software, sample maps are needed to calibrate
its functions. This is a Java application that can generate randomized maps of Mars, based on some input parameters. These
required parameters can change quickly based on potential new discoveries, so this software is written in a way that it can handle changes in a **flexible** way. 

![hero-image fill size_1200x675](https://github.com/BalintGeri/Mars-Exploration/assets/109275872/b80e9ee8-87fc-4476-99a5-7725bc1dbc57)

🛠️ The **technologies** used in the project:

* Maven
* Java 20
* IntelliJ (IDE)
* Git

All great, let's see the app in action and get a slice of the red planet on your screen!

👉 **Prerequisites:**

* Git
* openjdk
* IntelliJ community edition

are required to be installed on your system to run the application.

After cloning the repository, open it in the above mentioned IDE. Open Main.java which is under this directory relative from project root:

```
src/main/java/com/codecool/Main.java
```

You should see this screen and click on the little "play" button indicated by the arrow on the top toolbar in the IDE:

<img width="1440" alt="Screenshot 2023-06-06 at 12 16 04" src="https://github.com/BalintGeri/Mars-Exploration/assets/109275872/9aec115a-ff4f-49e4-8ac1-d969e5fa359f">

After clicking on the green "play" button, a terminal will open automatically in the IDE which will prompt you to input the parameters explained in the description below.

📋 **Instructions** and explanation for using the app:

The very first input needed is the size of the desired random map for the algorithm to generate, input an integer. Only one single number is required for this which will be both the vertical and horizontal size of our 2D map. For example, if 200 is fed into the app as map size upon startup, the map size will be 200x200 characters.

Four **types** of map objects will be generated by the algorithm with the following rules:

* mountains (^)
  - single mountain object
* pits (#)
  - single pit object
* minerals (*)
  - single mineral object
* pockets of water (~)
  - single water pocket object

**The first two are patch-like terrain elements** (covering a 2D continuous area on the map), **the latter two are point-like resources** (covering just one character on the map). Whitespaces are flat ground.

📒 **Rules** of map generation:

1. a given number of mineral resource points will be placed next to mountain groups (if there is enough room)
2. a given number of water pockets will be placed next to pits
3. the sizes of the terrain objects are randomized (except water pockets and minerals)
4. water is a rare commodity on Mars, they appear randomly in/near pits
5. minerals are also very rare, they appear randomly in/near mountains
6. the output with the given name (.txt is not required during input) is saved in a text file and stored at:

```
src/main/resources
```

relative from project root.

Here is an example generated map with the following parameters given:

1. map size = 30
2. number of mountains = 3
3. number of pits = 3

<img width="301" alt="Screenshot 2023-06-06 at 14 18 41" src="https://github.com/BalintGeri/Mars-Exploration/assets/109275872/b40db7e0-dcae-441f-acc4-a4ea86a3f34f">

The app is still under development, happy generating! 🙂
