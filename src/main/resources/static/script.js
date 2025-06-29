const endpoint = 'http://localhost:8080/shorten';


window.onload = function() {
    let submitButton = document.getElementById('submitButton');
    submitButton.onclick = async function() {
        let linkInput = document.getElementById('linkInput');
        let linkToSave = linkInput.value;

        let response = null;
        try {
            response = await fetch(endpoint + '?link=' + linkToSave , {
                method: 'POST',
            });
        } catch(error) {
            console.error('Something bad happened: ' + error.message);
            return;
        }

        response = await response.json();
        linkInput.value = response.shortLink;
    }
}




