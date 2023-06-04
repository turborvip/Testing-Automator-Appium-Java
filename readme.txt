./Appium-linux-1.20.2.AppImage to run

sudo gedit ~/.bashrc
export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64
export PATH=${PATH}:${JAVA_HOME}/bin
export PATH=~/.npm-global/bin:$PAT

adb devices : list device

JSON config : 
{
  "platformName": "Android",
  "deviceName": "emulator-5554",
  "app": "/home/turborvip/Appium/calculator.apk",
  "noReset": "true",
  "appWaitActivity": "com.application.calculator*"
}

tutorial : https://viettuts.vn/appium/vi-du-appium-kiem-thu-tu-dong-ung-dung-tren-android
           https://www.youtube.com/watch?v=LOQfhtHPPtI&ab_channel=SimpleSnipCode
           https://www.youtube.com/watch?v=buCBzDKJ1So&t=1223s&ab_channel=TestmasterCenter
           
           
           
