// Utils
// -----

module.exports = {

    /**
     * Generate malformed payloads
     * @param original the original correct payload
     * @return an array of malformed payloads
     */
    generateMalformed: function(original) {

        // An array for the malformed payload
        let payloads = [];

        // Here malformed means that a property is missing
        let keys = Object.keys(original);
        for(let i = 0; i < keys.length; i++) {
            let copy = JSON.parse(JSON.stringify(original));
            let missing = keys[i];
            delete copy[missing];
            payloads.push({
                what: 'missing field: ' + missing,
                payload: copy
            });
        }

        // Return the generated array
        return payloads;
    }
};