const createCheatForm = document.querySelector("#cheatform")
let language = document.querySelector("#name").value
let chMethod = document.getElementById('cheatMethod').value
let chBody = document.getElementById('cheatBody').value

const postCheat = (e) => {


    fetch('/cheats', {
        method: "POST",
        body: JSON.stringify(
            {
                "codeLanguage": language,
                "cheatMethod": chMethod,
                "cheatBody": chBody

        }),
        headers:{
            "Content-Type":"application/json"
        }
    }).then(res => {
        res.json().then(body => {

            document.body.innerHTML = JSON.stringify(body)
        })
    }).catch(e => {

        console.log(err)
    })
}
createCheatForm.addEventListener("click", (e) => {

  console.log(e);
  e.preventDefault();
  postCheat(e);
});



