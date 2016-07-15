// JavaScript Document
// printSWF('플레쉬 경로' , 넓이, 높이);
function printSWFHAVEID(idz, fn, w, h) {
    var arg = arguments;
    var argc = arguments.length;
    str = "<object id=\"" + idz + "\" classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0\"width=\"" + w + "\" height=\"" + h + "\">";
    str += "        <param name=\"SRC\" value=\"" + fn + "\">";
    for (i = 4; i < argc ; i++) {
        str += "        <param name=\"" + arg[i++] + "\" value=\"" + arg[i] + "\">";
    }
    str += "</object>";
    document.write(str);
}
// printSWF('플레쉬 경로' , 넓이, 높이);
function printSWF(fn, w, h) {
    var arg = arguments;
    var argc = arguments.length;
    str = "<object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0\"width=\"" + w + "\" height=\"" + h + "\">";
    str += "        <param name=\"SRC\" value=\"" + fn + "\">";
    str += "        <param name=\"wmode\" value=\"transparent\">";
    for (i = 3; i < argc ; i++) {
        str += "        <param name=\"" + arg[i++] + "\" value=\"" + arg[i] + "\">";
    }
    str += "        <embed wmode='transparent' src=\"" + fn + "\" pluginspage=\"http://www.macromedia.com/shockwave/download/\" type=\"application/x-shockwave-flash\" width=\"" + w + "\" height=\"" + h + "\">";
    str += "        </embed> ";
    str += "</object>";
    document.write(str);
}

function printMEDIA(id, fn, w, h) {

    objstr = "<OBJECT id=\"" + id + "\" name=\"" + id + "\" classid=\"CLSID:22D6f312-B0F6-11D0-94AB-0080C74C7E95\" codebase=\" ";
    objstr += "http://activex.microsoft.com/activex/controls/mplayer/en/nsmp2inf.cab#Version=5,1,52,701\" ";
    objstr += "standby=\"Loading Microsoft Windows Media Player components...\" ";
    objstr += "type=\"application/x-oleobject\" bgcolor=\"DarkBlue\" ";
    objstr += "width=\"" + w + "\" height=\"" + h + "\" ";
    objstr += ">";
    objstr += " <PARAM NAME=\"Filename\" VALUE=\"" + fn + "\">";
    objstr += "      <param name=\"ClickToPlay\" value=\"true\">";
    objstr += "      <param name=\"width\" value=\"" + w + "\">";
    objstr += "      <param name=\"height\" value=\"" + h + "\">";
    objstr += "      <param name=\"AutoSize\" value=\"true\">";
    objstr += "      <param name=\"AutoStart\" value=\"true\">";
    objstr += "      <param name=\"ShowControls\" value=\"false\">";
    objstr += "      <param name=\"ShowAudioControls\" value=\"true\">";
    objstr += "      <param name=\"ShowDisplay\" value=\"false\">";
    objstr += "      <param name=\"ShowTracker\" value=\"true\">";
    objstr += "      <param name=\"ShowStatusBar\" value=\"true\">";
    objstr += "      <param name=\"EnableContextMenu\" value=\"false\">";
    objstr += "      <param name=\"ShowPositionControls\" value=\"false\">";
    objstr += "      <param name=\"ShowCaptioning\" value=\"false\">";
    objstr += "      <param name=\"AutoRewind\" value=\"true\">";
    objstr += "      <param name=\"Enabled\" value=\"true\">";
    objstr += "      <param name=\"EnablePositionControls\" value=\"true\">";
    objstr += "      <param name=\"EnableTracker\" value=\"true\">";
    objstr += "      <param name=\"PlayCount\" value=\"1\">";
    objstr += "      <param name=\"SendWarningEvents\" value=\"true\">";
    objstr += "      <param name=\"SendErrorEvents\" value=\"true\">";
    objstr += "      <param name=\"SendKeyboardEvents\" value=\"false\">";
    objstr += "      <param name=\"SendMouseClickEvents\" value=\"false\">";
    objstr += "      <param name=\"SendMouseMoveEvents\" value=\"false\">";
    objstr += "      <param name=\"ShowGotoBar\" value=\"false\">";
    objstr += "      <param name=\"TransparentAtStart\" value=\"false\">";
    objstr += "      <param name=\"Volume\" value=\"50\">";
    objstr += "	  <param name=\"DisplaySize \" value=\"0\">";
    objstr += "</OBJECT>";
    return objstr;
}

function playMovie(id, fn, w, h) {
    document.all.oDivPlayer.innerHTML = printMEDIA(id, fn, w, h)
    obj = eval("document.all." + id);
    obj.Filename = fn;
    setTimeout("VodPlay('" + id + "')", 1000);
}

function VodPause(id) {
    obj = eval("document.all." + id);
    if (obj) obj.pause();
}

function VodPlay(id) {
    obj = eval("document.all." + id);
    if (obj) obj.play();
}

function VodStop(id) {
    obj = eval("document.all." + id);
    if (obj) obj.stop();
}