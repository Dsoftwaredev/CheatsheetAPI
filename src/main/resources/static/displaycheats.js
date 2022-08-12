const responseField = document.querySelector('#responseField');
const cheats = document.querySelector('#cheats')

// Renders response before it is modified
const renderRawResponse = (res) => {
  // Takes the first 10 words from res
  let response = res;
  // Manipulates responseField to render the unformatted response
  responseField.innerHTML = `<text>${JSON.stringify(response)}</text>`;
}


const getCheats = () => {
  fetch('/cheats').then(response => {
console.log('teststock')
      response.json().then(jsonResponse => {
                               renderRawResponse(jsonResponse);
                              //  renderResponse(jsonResponse);
                              })

  }).catch( networkError => {
              console.log(networkError.message)
            })
}

const displaycheats = (event) => {
    event.preventDefault()
    console.log('Teststock2');
  getCheats();
};

cheats.addEventListener('click', displaycheats);

