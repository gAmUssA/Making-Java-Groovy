/* ===================================================
 * Copyright 2012 Kousen IT, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================== */
package mjg.xml;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import mjg.scripting.Location

class GeocoderV3Test {
    Location loc
    GeocoderV3 geocoder
    
    @Before
    void setUp() {
        loc = new Location(street:'1600 Ampitheatre Parkway',
            city:'Mountain View',state:'CA')
        geocoder = new GeocoderV3()
    }
    
    @Test
    void testFillInLatLng() {
        assertTrue loc.latitude < 0.1
        assertTrue loc.longitude < 0.1
        loc = geocoder.fillInLatLng(loc)
        def google_lat = 37.422
        def google_lng = -122.083
        assertTrue Math.abs(loc.latitude - google_lat) < 0.01
        assertTrue Math.abs(loc.longitude - google_lng) < 0.01
    }

}
