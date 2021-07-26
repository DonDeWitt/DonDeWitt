/* solids.js - do solid geometry form validation
 *
 
 * D DeWitt, 11 Nov 2020
 */

function solid_compute()
{
  // Assume no radio button chosen
  var RadioChosen = false;
  // Assume no data requested
  var DataRequest = false;
  var QueryString = "?";
  
  if ( $("#solidCu").prop("checked") ) {
    RadioChosen = true;
    QueryString += "solid=cube";
    if ( $("#height").val().length == 0 ) {
      alert("Please give a height.");
      $("#height").focus();
      return;
    }
    QueryString += '&height=' + $("#height").val();
  }
  
  if ( $("#solidSp").prop("checked") ) {
    RadioChosen = true;
    QueryString += "solid=sphere";
    if ( $("#radius").val().length == 0 ) {
      alert("Please give a radius.");
      $("#radius").focus();
      return;
    }
    QueryString += '&radius=' + $("#radius").val();
  }
    if ( $("#solidCy").prop("checked") ) {
    RadioChosen = true;
    QueryString += "solid=cylinder";
	if ( $("#height").val().length == 0 && $("#radius").val().length == 0) {
      alert("Please give a height or radius!.");
	  $("#height").focus();
      return;
    }
    if ( $("#radius").val().length == 0 ) {
      alert("Please give a radius.");
      $("#radius").focus();
      return;
    }
    if ( $("#height").val().length == 0 ) {
      alert("Please give a height.");
      $("#height").focus();
      return;
    }
    
    QueryString += '&radius=' + $("#radius").val();
    QueryString += '&height=' + $("#height").val();
  }
    
  
  if ( ! RadioChosen ) {
    alert("Please choose a solid.");
    return;
  }
  
  if ( $("#area").prop("checked") ) {
    DataRequest = true;
    QueryString += "&area=on"
  }

  if ( $("#volume").prop("checked") ) {
    DataRequest = true;
    QueryString += "&volume=on"
  }
  if ( ! DataRequest ) {
    alert("You did not request any data.")
    return;
  }
  
  // Prepare data to send to CGI
  CGI = 'http://elvis.rowan.edu/~dewittd2/Solids/solids.cgi';
  URL = CGI + QueryString
  console.log('Fetching: ' + URL);
  $.ajax({url: URL,
         success: function(result){ 
           $("#output").text(result);
         }})
}