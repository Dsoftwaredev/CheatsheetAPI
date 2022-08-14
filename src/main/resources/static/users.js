const postUser = (e) => {

    let uname = document.getElementById('uname').value;
    let email = document.getElementById('email').value;

    fetch('/users', {
        method: "POST",
        body: JSON.stringify(
            {
                "name": uname,
                "email": email

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


const getUsers = () => {
  fetch('/users').then(response => {
console.log('test2')
      response.json().then(jsonResponse => {
                               renderRawResponse(jsonResponse);
                            //   renderResponse(jsonResponse);
                              })

  }).catch( networkError => {
              console.log(networkError.message)
            })
}
const renderRawResponse = (res) => {
  let response = res;
  responseField.innerHTML = `<text>${JSON.stringify(response)}</text>`;
}






const updateUser = (e) => {

    let updateId = document.getElementById('updateId').value;
    let updateName = document.getElementById('updateName').value;
    let updateEmail = document.getElementById('updateEmail').value;

    fetch(`/users/${updateId}`, {
        method: "PUT",
        body: JSON.stringify(
            {
                "name": updateName,
                "email": updateEmail

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



const deleteUser = (e) => {
let deleteUserId = document.getElementById('deleteUserId').value;
fetch(`/users/${deleteUserId}`, {
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

