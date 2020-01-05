package ch.bfh.ti.cookingWebapp.persistence.service;

import ch.bfh.ti.cookingWebapp.persistence.model.Option;
import ch.bfh.ti.cookingWebapp.persistence.model.Recipe;
import ch.bfh.ti.cookingWebapp.persistence.model.Tag;
import ch.bfh.ti.cookingWebapp.persistence.model.TagType;
import ch.bfh.ti.cookingWebapp.persistence.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TagServices {
    private TagRepository tagRepository;

    @Autowired
    public TagServices(TagRepository tagRepository) {
        super();
        this.tagRepository = tagRepository;
    }

    public List<Tag> getAllTags() {
        List<Tag> tags = new ArrayList<>();
        this.tagRepository.findAll().forEach(tags::add);
        return tags;
    }

    public Tag getTagByName(String tagName) {
        List<Tag> tags = getAllTags();
        for (Tag t: tags){
            if (t.getTagName().equals(tagName)) {
                return t;
            }
        }
        return null;
    }

    public Tag getTagById(Long tagId){
        Optional<Tag> tag = tagRepository.findById(tagId);
        return tag.orElse(null);
    }

    public void addTag(String tagName, long tagType) {
        Tag tag = new Tag();
        tag.setTagName(tagName);
        tag.setType(tagType);
        this.tagRepository.save(tag);
    }

    public List<Tag> getTagsByType(TagType type) {
        List<Tag> allTags = getAllTags();
        List<Tag> tags = new ArrayList<>();
        for (Tag t:allTags){
            if (t.getType() == (type.tagNumber())) {
                tags.add(t);
            }
        }
        return tags;
    }

    public List<Option> getOptionList() {
        List<Option> options = new ArrayList<>();
        options.add(new Option(TagType.COURSE.tagNumber(), TagType.COURSE.type()));
        options.add(new Option(TagType.CUISINE.tagNumber(), TagType.CUISINE.type()));
        options.add(new Option(TagType.DIET.tagNumber(), TagType.DIET.type()));

        return options;
    }
}
