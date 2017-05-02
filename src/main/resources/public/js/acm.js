function setFields(bibtex) {
  document.getElementById("entrytype-dropdown").value = bibtex.entryType;
  updateFields();
  document.querySelector("input[name=entrykey]").value = bibtex.citationKey;
  Object.keys(bibtex.entryTags).forEach(key => {
    let field = document.querySelector(`input[name=${key}]`);
    if (field) {
      field.value = bibtex.entryTags[key];
    }
  });
}

function throwErrors(response) {
  if (response.status === 404) {
    throw Error("Ei löytynyt viitettä");
  } else if (!response.ok) {
    throw Error("Virheellinen linkki");
  }
  return response.text();
}

function fetchAcm() {
  let statusText = document.getElementById("acm-status");
  statusText.innerHTML = "";
  let input = document.getElementById("acm-input");
  let url = input.value;
  input.value = "lataa...";
  fetch("/acm/" + url).then(res => (
    throwErrors(res)
  )).then(text => {
    setFields(bibtexParse.toJSON(text)[0]);
  }).catch(error => {
    statusText.innerText = error.message;
  }).then(() => input.value = "");
}
