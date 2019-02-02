Set oArgs = WScript.Arguments
Set oNamedArgs = WScript.Arguments.Named
Set OUnnamedArgs = WScript.Arguments.Unnamed

WScript.Echo "-- WScript.Arguments --"
nArgc = oArgs.Count
WScript.Echo "Arguments count : " & nArgc
For i = 0 To nArgc - 1
   WScript.Echo oArgs(i)
Next

WScript.Echo "-- WScript.Arguments.Named --"
WScript.Echo "Named Count   : " & oNamedArgs.Count
If oNamedArgs.Exists("foo") Then
  WScript.Echo "foo = " & oNamedArgs.Item("foo")
End If

If oNamedArgs.Exists("bar") Then
  WScript.Echo "bar = " & oNamedArgs.Item("bar")
End If

WScript.Echo "-- WScript.Arguments.Unnamed --"
WScript.Echo "Unnamed Count : " & oUnnamedArgs.Count
For i = 0 To oUnnamedArgs.Count - 1
  WScript.Echo oUnnamedArgs.Item(i)
Next

Set oArgs = Nothing
Set oNamedArgs = Nothing
Set OUnnamedArgs = Nothing
