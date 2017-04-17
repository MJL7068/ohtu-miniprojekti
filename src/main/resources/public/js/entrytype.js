const types = {
  article: {
    required: ["entrykey", "author", "title", "journal", "year", "volume"],
    optional: ["number", "pages", "month", "note", "key"],
  },
  book: {
    required: ["entrykey", "author", "title", "publisher", "year"],
    optional: ["volume", "series", "address", "edition", "month", "note", "key"],
  },
  inproceedings: {
    required: ["entrykey", "author", "title", "booktitle", "year"],
    optional: [
      "editor", "volume", "series", "pages", "address", "month", "organization",
      "publisher", "note", "key",
    ],
  },
};

function createInput(field, required) {
  let input = document.createElement("input");
  if (required) {
    input.setAttribute("required", "");
  }
  input.type = "text";
  input.className = "form-control";
  input.className += required ? " required" : " optional";
  input.id = field;
  input.name = field;
  return input;
}

function createSections(fields, required) {
  return fields.map(field => {
    let section = document.createElement("section");
    section.className = "form-group";

    let label = document.createElement("label");
    label.innerText = field;
    section.appendChild(label);
    section.appendChild(createInput(field, required));
    return section;
  });
}

function updateFields() {
  let selection = document.getElementById("entrytype-dropdown").value;
  let requireds = document.getElementById("required-inputs");
  requireds.innerHTML = "";

  let optionals = document.getElementById("optional-inputs");
  optionals.innerHTML = "";
  createSections(types[selection].required, true).forEach(input => {
    requireds.appendChild(input);
  });
  createSections(types[selection].optional, false).forEach(input => {
    optionals.appendChild(input);
  });
}

updateFields();
