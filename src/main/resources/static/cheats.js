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
