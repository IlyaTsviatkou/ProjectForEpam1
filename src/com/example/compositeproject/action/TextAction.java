package com.example.compositeproject.action;

import com.example.compositeproject.comparator.TextComparator;
import com.example.compositeproject.entity.ComponentText;
import com.example.compositeproject.entity.CompositeText;
import com.example.compositeproject.entity.CustomSymbol;
import com.example.compositeproject.entity.TypeComponent;
import com.example.compositeproject.exception.CustomException;

import java.util.*;

public class TextAction {
    //public static Logger logger = LogManager.getLogger();
    private static final String CONSONANTS_REGEX = "(?![aeiou])[a-z]";
    private static final String VOWEL_REGEX = "[aeiou]";

    public ArrayList<ComponentText> findSentencesWithLongestWord(ComponentText text) throws CustomException {
        if (text == null || text.getType()!=TypeComponent.TEXT) {
            throw new CustomException("component is invalid");
        }
        ArrayList<ComponentText> sentences = new ArrayList<ComponentText>();
        int maxWordLength = 0;
        int tempMaxLength = 0;
        for (ComponentText paragraphComponent : text.getComponents()) {
            for (ComponentText sentenceComponent : paragraphComponent.getComponents()) {
                for (ComponentText lexemeComponent : sentenceComponent.getComponents()) {
                    for (ComponentText word : lexemeComponent.getComponents()) {
                        if (word.getType() == TypeComponent.WORD && word.countSymbol() > tempMaxLength) {
                                tempMaxLength = word.countSymbol();
                        }
                    }
                }
                if(tempMaxLength > maxWordLength) {
                    sentences.clear();
                    maxWordLength = tempMaxLength;
                    sentences.add(sentenceComponent);
                } else if (tempMaxLength == maxWordLength) {
                    sentences.add(sentenceComponent);
                }
                tempMaxLength = 0;
            }
        }
       // logger.log(Level.INFO,
       //         "the longest word " + longestWord.toString() + " in sentence :" + sentenceWithLongestWord.toString());
        return sentences;
    }

    public void removeSentencesWithWordsLessNumber(ComponentText text, int numberWords) throws CustomException {
        if (text == null || text.getType()!=TypeComponent.TEXT) {
            throw new CustomException("component is invalid");
        }
        int counter = 0;
        List<ComponentText> paragraphs = new ArrayList<>(text.getComponents());
        List<ComponentText> paragraphsToDelete = new ArrayList<>();
        for (ComponentText paragraphComponent : paragraphs) {
            for (ComponentText sentenceComponent : paragraphComponent.getComponents()) {
                for (ComponentText lexemeComponent : sentenceComponent.getComponents()) {
                    for (ComponentText lexemeElement : lexemeComponent.getComponents()) {
                        if (lexemeElement.getType() == TypeComponent.WORD) {
                            counter++;
                        }
                    }
                }
                if (counter < numberWords) {
                    if(paragraphComponent.getComponents().size()==1)
                    {
                        paragraphsToDelete.add(paragraphComponent);
                    } else {
                        ((CompositeText) paragraphComponent).removeComponent(sentenceComponent);
                    }
                }
                counter = 0;
            }
        }
            paragraphs.removeAll(paragraphsToDelete);

        ((CompositeText) text).setComponents(paragraphs);
//        logger.log(Level.INFO,
//                "text after removing sentences with fewer words " + numberWords + " :" + text.toString());
       // return text;
    }

    public Map<String, Integer> findIdenticalWordsAndNumber(ComponentText text) throws CustomException {
        if (text == null || text.getType()!=TypeComponent.TEXT) {
            throw new CustomException("component is invalid");
        }
        Map<String, Integer> identicalWords = new HashMap<>();
        for (ComponentText paragraphComponent : text.getComponents()) {
            for (ComponentText sentenceComponent : paragraphComponent.getComponents()) {
                for (ComponentText lexemeComponent : sentenceComponent.getComponents()) {
                    for (ComponentText word : lexemeComponent.getComponents()) {
                        if (word.getType() == TypeComponent.WORD) {
                            String wordNew = word.toString().toLowerCase();
                            Integer previousValue = identicalWords.put(wordNew, 1);
                            if (previousValue != null) {
                                identicalWords.put(wordNew, ++previousValue);
                            }
                        }
                    }
                }
            }
        }
        for(Map.Entry<String,Integer> entry : identicalWords.entrySet()) {
            if(entry.getValue()==1) {
                identicalWords.remove(entry);
            }
        }
       // logger.log(Level.INFO, "identical words in the text and their number: " + identicalWords.toString());
        return identicalWords;
    }

    public void sortParagraphsWithNumberOfSentences(ComponentText text) throws CustomException {
        if (text == null || text.getType()!=TypeComponent.TEXT) {
            throw new CustomException("component is invalid");
        }
        List<ComponentText> paragraphs = new ArrayList<>(text.getComponents());
        TextComparator comparator = new TextComparator();
        paragraphs.sort(comparator);
        //logger.log(Level.INFO, "components after sort: " + components.toString());
        ((CompositeText) text).setComponents(paragraphs);
    }

    public int calculateConsonants(ComponentText text) throws CustomException {
        int counter = 0;
        for (ComponentText paragraphComponent : text.getComponents()) {
            for (ComponentText sentenceComponent : paragraphComponent.getComponents()) {
                for (ComponentText lexemeComponent : sentenceComponent.getComponents()) {
                    for (ComponentText lexemeElement : lexemeComponent.getComponents()) {
                        if(lexemeElement.getType() == TypeComponent.WORD) {
                            for (ComponentText symbol : lexemeElement.getComponents()) {
                                if (symbol.getType() == TypeComponent.LETTER) {
                                    if (String.valueOf(((CustomSymbol) symbol).getValue()).matches(CONSONANTS_REGEX)) {
                                        counter++;
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
        return counter;
    }

    public int calculateVowels(ComponentText text) throws CustomException {
        int counter = 0;
        for (ComponentText paragraphComponent : text.getComponents()) {
            for (ComponentText sentenceComponent : paragraphComponent.getComponents()) {
                for (ComponentText lexemeComponent : sentenceComponent.getComponents()) {
                    for (ComponentText lexemeElement : lexemeComponent.getComponents()) {
                        if(lexemeElement.getType() == TypeComponent.WORD) {
                            for (ComponentText symbol : lexemeElement.getComponents()) {
                                if (symbol.getType() == TypeComponent.LETTER) {
                                    if (String.valueOf(((CustomSymbol) symbol).getValue()).matches(VOWEL_REGEX)) {
                                        counter++;
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
        return counter;
    }
}
