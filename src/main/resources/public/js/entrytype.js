const f = {
  entrykey: "entrykey",
  address: "address",
  annote: "annote",
  author: "author",
  booktitle: "booktitle",
  chapter: "chapter",
  crossref: "crossref",
  edition: "edition",
  editor: "editor",
  howpublished: "howpublished",
  institution: "institution",
  journal: "journal",
  key: "key",
  month: "month",
  note: "note",
  number: "number",
  organization: "organization",
  pages: "pages",
  publisher: "publisher",
  school: "school",
  series: "series",
  title: "title",
  type: "type",
  volume: "volume",
  year: "year",
};

const types = {
  article: {
    required: [f.author, f.title, f.journal, f.year, f.volume],
    optional: [f.entrykey, f.number, f.pages, f.month, f.note, f.key],
  },
  book: {
    required: [f.author, f.title, f.publisher, f.year],
    optional: [f.entrykey, f.volume, f.series, f.address, f.edition, f.month, f.note, f.key],
  },
  booklet: {
    required: [f.title],
    optional: [f.entrykey, f.author, f.howpublished, f.address, f.month, f.year, f.note, f.key],
  },
  conference: {
    required: [f.author, f.title, f.booktitle, f.year],
    optional: [
      f.entrykey, f.editor, f.volume, f.series, f.pages, f.address, f.month,
      f.organization, f.publisher, f.note, f.key,
    ],
  },
  inbook: {
    required: [f.author, f.title, f.chapter, f.pages, f.publisher, f.year],
    optional: [
      f.entrykey, f.volume, f.series, f.type, f.address, f.edition, f.month,
      f.note, f.key,
    ],
  },
  incollection: {
    required: [f.author, f.title, f.booktitle, f.publisher, f.year],
    optional: [
      f.entrykey, f.edition, f.volume, f.series, f.type, f.chapter, f.pages,
      f.address, f.edition, f.month, f.note, f.key,
    ],
  },
  inproceedings: {
    required: [f.author, f.title, f.booktitle, f.year],
    optional: [
      f.entrykey, f.editor, f.volume, f.series, f.pages, f.address, f.month,
      f.organization, f.publisher, f.note, f.key,
    ],
  },
  manual: {
    required: [f.author, f.title, f.booktitle, f.year],
    optional: [
      f.entrykey, f.editor, f.volume, f.series, f.pages, f.address, f.month,
      f.organization, f.publisher, f.note, f.key,
    ],
  },
  mastersthesis: {
    required: [f.author, f.title, f.school, f.year],
    optional: [f.entrykey, f.type, f.address, f.month, f.note, f.key],
  },
  misc: {
    required: [],
    optional: [
      f.entrykey, f.author, f.title, f.howpublished, f.month, f.year, f.note,
      f.key,
    ],
  },
  phdthesis: {
    required: [f.author, f.title, f.school, f.year],
    optional: [f.entrykey, f.type, f.address, f.month, f.note, f.key],
  },
  proceedings: {
    required: [f.title, f.year],
    optional: [
      f.entrykey, f.editor, f.volume, f.series, f.address, f.month,
      f.organization, f.publisher, f.note, f.key,
    ],
  },
  techreport: {
    required: [f.author, f.title, f.institution, f.year],
    optional: [f.entrykey, f.type, f.number, f.address, f.month, f.note, f.key],
  },
  unpublished: {
    required: [f.author, f.title, f.note],
    optional: [f.entrykey, f.month, f.year, f.key],
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
