package miniproju.models;

import java.util.ArrayList;
import java.util.Arrays;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import miniproju.utilities.BibtexGenerator;

/**
 * @author ilkka
 */
@Entity
public class Reference extends AbstractPersistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String entryType;
    private String entryKey;

    // Entry fields
    private String address;
    private String annote;
    private String author;
    private String booktitle;
    private String chapter;
    private String crossref;
    private String edition;
    private String editor;
    private String howpublished;
    private String institution;
    private String journal;
    private String key;
    private String month;
    private String note;
    private String number;
    private String organization;
    private String pages;
    private String publisher;
    private String school;
    private String series;
    private String title;
    private String type;
    private String volume;
    private Integer year;

    public Reference() {
    }

    public Reference(String title) {
        this.title = title;
    }

    public Map<String, Object> allFields() {
        Map<String, Object> fields = new LinkedHashMap<>();
        fields.put("address", address);
        fields.put("annote", annote);
        fields.put("author", author);
        fields.put("booktitle", booktitle);
        fields.put("chapter", chapter);
        fields.put("crossref", crossref);
        fields.put("edition", edition);
        fields.put("editor", editor);
        fields.put("howpublished", howpublished);
        fields.put("institution", institution);
        fields.put("journal", journal);
        fields.put("key", key);
        fields.put("month", month);
        fields.put("note", note);
        fields.put("number", number);
        fields.put("organization", organization);
        fields.put("pages", pages);
        fields.put("publisher", publisher);
        fields.put("school", school);
        fields.put("series", series);
        fields.put("title", title);
        fields.put("type", type);
        fields.put("volume", volume);
        fields.put("year", year);
        return fields;
    }

    /**
     * Get all non-null fields.
     *
     * @return map of fields where none is null.
     */
    public Map<String, Object> fields() {
        Map<String, Object> map = allFields();
        map.values().removeIf(v -> v == null);
        return map;
    }

    public String toBibtexString() {
        return BibtexGenerator.toBibtex(entryType, entryKey, fields());
    }

    public List<String> getAuthorSurnames() {
        List<String> surnames = new ArrayList<>();
        
        if (author != null) {
        surnames = Pattern.compile(" and ")
                .splitAsStream(author)
                .map(authors -> authors.split(",")[0].trim())
                .collect(Collectors.toList());
        }
        
        return surnames;
    }

    // Generated code below
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    public String getEntryKey() {
        return entryKey;
    }

    public void setEntryKey(String entryKey) {
        this.entryKey = entryKey;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAnnote() {
        return annote;
    }

    public void setAnnote(String annote) {
        this.annote = annote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getCrossref() {
        return crossref;
    }

    public void setCrossref(String crossref) {
        this.crossref = crossref;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getHowpublished() {
        return howpublished;
    }

    public void setHowpublished(String howpublished) {
        this.howpublished = howpublished;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public int getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
