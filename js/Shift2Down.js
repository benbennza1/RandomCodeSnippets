/*
* 	Q: If NEW YORK can be encrypted as PGYAQTM, how can you code the word CHARLOTTE?
		1. EICSNPVVG
		2. EJCTNQVVG
		3. EICTNPVVF
		4. EJCSMPVVG

	Assumptions: input is always all caps, no symbols.
*/
function shift2down(a) {
    let encrypt = "";
    let eChar = "";
    a.split("").forEach(function(e) {
        if (e != " ") {
            eChar = String.fromCharCode(e.charCodeAt(0) + 2);
            eChar > "Z"
                ? (encrypt += String.fromCharCode(e.charCodeAt(0) - 24))
                : (encrypt += eChar);
        }
    });
    console.log(encrypt);
}
