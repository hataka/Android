Set oArgs = WScript.Arguments

nArgc = oArgs.Count
WScript.Echo "Arguments count : " & nArgc

For i = 0 To nArgc - 1
   WScript.Echo oArgs(i)
Next

Set oArgs = Nothing
