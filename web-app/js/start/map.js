/**
 * Created with IntelliJ IDEA.
 * User: denise
 * Date: 7/6/13
 * Time: 3:54 PM
 * To change this template use File | Settings | File Templates.
 */

var map = L.map('map').setView([40.212441, -98.180695], 4);
//L.tileLayer('http://{s}.tile.cloudmade.com/e5bae9c9900b40e398c3491520c6af60/997/256/{z}/{x}/{y}.png', {
//    attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, <a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="http://cloudmade.com">CloudMade</a>',
//    maxZoom: 18
//}).addTo(map);
L.tileLayer('http://{s}.tile.stamen.com/terrain/{z}/{x}/{y}.png', {
    attribution: [
            'Map tiles by <a href="http://stamen.com">Stamen Design</a>, ',
            'under <a href="http://creativecommons.org/licenses/by/3.0">CC BY 3.0</a>. ',
            'Data by <a href="http://openstreetmap.org">OpenStreetMap</a>, ',
            'under <a href="http://creativecommons.org/licenses/by-sa/3.0">CC BY SA</a>.'
        ].join(""),
    minZoom:4,
    maxZoom: 18
}).addTo(map);
