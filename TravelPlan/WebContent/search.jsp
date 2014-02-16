<jsp:include page="template-top.jsp" />

<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=places"></script>

<script>
function initialize() {

  var input = /** @type {HTMLInputElement} */(
      document.getElementById('searchPlace'));

  var autocomplete = new google.maps.places.Autocomplete(input);
  autocomplete.bindTo('bounds', map);

  var infowindow = new google.maps.InfoWindow();
  var marker = new google.maps.Marker({
    map: map
  });

  google.maps.event.addListener(autocomplete, 'place_changed', function() {
    infowindow.close();
    marker.setVisible(false);
    var place = autocomplete.getPlace();
    if (!place.geometry) {
      return;
    }

    // If the place has a geometry, then present it on a map.
   

    var address = '';
    if (place.address_components) {
      address = [
        (place.address_components[0] && place.address_components[0].short_name || ''),
        (place.address_components[1] && place.address_components[1].short_name || ''),
        (place.address_components[2] && place.address_components[2].short_name || '')
      ].join(' ');
    }

    infowindow.setContent('<div><strong>' + place.name + '</strong><br>' );
  });

}

google.maps.event.addDomListener(window, 'load', initialize);

    </script>
<div class="container">

	<!-- Main hero unit for a primary marketing message or call to action -->
	<div class="hero-unit" align="center">
		<jsp:include page="error-list.jsp" />
		<h1>Welcome to Travel Plan!</h1>
		<br>
		<h3>Simple 3 steps to start with</h3>
		<p>· entering places you would like to visit</p>
		<p>· select pictures and tweets</p>
		<p>· share your own travel plan on twitter</p>
		<p>
		<form class="form-search" method="POST" action="search.do">
			<input id="searchPlace" type="text" name="place" class="input-medium search-query"
				placeholder="street, city, country..">
			<button type="submit" class="btn btn-primary">
				<i class="icon-search icon-white"></i> Search
			</button>
		</form>
		</p>
	</div>

	<jsp:include page="template-bottom.jsp" />