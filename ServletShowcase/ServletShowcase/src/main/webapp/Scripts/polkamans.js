function get(url){
	return new Promise((resolve, reject) =>{
		let xhr = new XMLHttpRequest(); // ready state is 0; the xml http
										// request has been created
		
		// Each xml http request has a property called the onreadystatechange;
		// we can set
		// this property equal to a function which is called each time the ready
		// state changes
		xhr.onreadystatechange = function(){
			
			if(xhr.readyState == 4){
				
				if(xhr.status == 200){
					
				resolve(JSON.parse(xhr.response));
			}
			
			else{
				console.log("There's an error.")
				reject(Error("Oops. Something went wrong."));
			}
			}
		}
		
		xhr.open("GET", url); // ready state is 1; the xml Http Request has //
								// been opened
		xhr.send(); // the ready is 2; the xml http request has been sent
		
});
}

function getPolkamanMasters(){
	let url = "../GetPolkamans";
	
	let selectBox = document.getElementById("selectBox");
	
	console.log("in get Polkaman masters")
	let results = get(url).then(data => {
		console.log(data);
		
		// Enhanced for loop in JavaScript
		for(let d in data){
			let option = document.createElement("option");
			option.innerHTML = data[d]["name"];
			option.value = data[d]["id"];
			selectBox.append(option);
		}
	}).catch(error => {
		console.log("Hey, where's my data man?!")
	});
	
}

// The value of results is, in fact, going to be a promise because you can only
// access the
// data a promise returns when you're inside of the .then callback function
// console.log(results);

window.onload = function(){
	getPolkamanMasters();
}