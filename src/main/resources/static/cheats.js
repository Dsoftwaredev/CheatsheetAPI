const postCheats = () => {
        let language = document.getElementById("cheatname").value;
        let chMethod = document.getElementById("cheatmth").value;
        let chBody = document.getElementById("cheatbod").value;

        console.log(JSON.stringify({
                "codeLanguage": language,
                                    "cheatMethod": chMethod,
                                    "cheatBody": chBody
            }))

        fetch("/cheats?", {
                    method: "POST",
                    body: JSON.stringify({
                        "codeLanguage": language,
                                                            "cheatMethod": chMethod,
                                                            "cheatBody": chBody
                    }),
                    headers: {
                        "Content-Type": "application/json"
                    }
                }
            ).then(res => {
                res.json().then(body => {

                   });
                })
            .catch(err =>{
                console.log(err);
            })
}

const deleteCheat = (e) => {
let deleteId = document.getElementById('deleteCheatID').value;
fetch(`/cheats/${deleteId}`, {
    method: "DELETE",
    headers: {
        'Content-type': 'application/json'
    }
}).then(res => {
    if (res.ok) { console.log("HTTP request successful") }
    else { console.log("HTTP request unsuccessful") }
    return res
})
.then(res => res.json())
.then(data => console.log(data))
.catch(error => console.log(error))
}

const updateCheat = (e) => {
let id = document.getElementById('updateid').value;
let languageone = document.querySelector("#updatename").value
let  chMethodtwo= document.querySelector('#updatemethod').value
let chBodythree = document.querySelector('#updateBody').value
    fetch(`/cheats/${id}`, {
        method: "PUT",
        body: JSON.stringify(
            {
                "codeLanguage": languageone,
                                "cheatMethod": chMethodtwo,
                                "cheatBody": chBodythree
        }),
        headers:{
            "Content-Type":"application/json"
        }
    }).then(res => {
        res.json().then(body => {
            document.body.innerHTML = JSON.stringify(body)
        })
    }).catch(err => {
        console.log(err)
    })
}

const renderRawResponse = (res) => {
  // Takes the first 10 words from res
  let response = res;
  // Manipulates responseField to render the unformatted response
  responseField.innerHTML = `<text>${JSON.stringify(response)}</text>`;
}


const getCheats = () => {
const responseField = document.querySelector('#responseField');
const cheats = document.querySelector('#cheats')
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