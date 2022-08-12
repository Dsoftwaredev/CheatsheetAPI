let deleteCheatForm = document.getElementById('deletec')
let deleteId = document.getElementById('deleteCheatID').value;

const deleteCheat = (e) => {
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
deleteCheatForm.addEventListener('click', (e) => {
    e.preventDefault();
    console.log(e);
    deleteCheat();
})