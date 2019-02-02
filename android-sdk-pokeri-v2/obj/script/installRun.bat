"F:\GitHub\android-sdk-pokeri-v2\obj\script\launchAVD.wsf" -avd Tablet28
timeout /t 60 > nul
"C:\AndroidStudio32\sdk\platform-tools\adb.exe" install F:\mnt\sdcard\www\public\android\android-sdk-pokeri-v2\Chapter01\layout_ConstraintLayout\app\build\outputs\apk\debug\app-debug.apk
timeout /t 10 > nul
START /WAIT "C:\AndroidStudio32\sdk\platform-tools\adb.exe" shell am start -n net.buildbox.pokeri.layout_constraintlayout/net.buildbox.pokeri.layout_constraintlayout.MainActivity
