const updateCheats = document.querySelector("#updateformcheat");
let id = document.getElementById('updateid').value;

let languageone = document.querySelector("#updatename").value
let  chMethodtwo= document.querySelector('#updatemethod').value
let chBodythree = document.querySelector('#updateBody').value

const updateCheat = (e) => {
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

updateCheats.addEventListener('click', (e) => {
    e.preventDefault();
    console.log(e);
    updateCheat(e);
    });