package com.fbs.webapp.validation;

import java.util.LinkedHashMap;
import java.util.Map;
import org.passay.PasswordData;
import org.passay.Rule;
import org.passay.RuleResult;
import org.passay.dictionary.Dictionary;

/* ===== The Validation Classes are Under Development. The code in this folder shows the beginning of the development. ===== */

/* -- This section was learnt from: Passy's documentation for "DictionaryRule" - @author  Middleware Services -- */
/* ===== Aim: Blacklist Common Vulnerable Passwords over 8 Characters ===== */
public abstract class DictionaryBlacklist implements Rule{

  /* ===== Dictionary of Words ===== */
  private Dictionary dictionary;

  private String getErrorCode(boolean b) {
    return null;
  }

  /* ===== Set the Dictionary used to search for passwords ===== */
  public void setDictionary(final Dictionary dict){
    if (dict == null) {
      throw new NullPointerException("Dictionary cannot be null");
    }
    dictionary = dict;
  }

  @Override
  public RuleResult validate(final PasswordData passwordData){
    final RuleResult result = new RuleResult();
    String text = passwordData.getPassword();
    String matchingWord = doWordSearch(text);
    if (matchingWord != null){
      result.addError(getErrorCode(false), createRuleResultDetailParameters(matchingWord));
    }
    return result;
  }

  /* ===== Blacklisted Words ===== From a list of Vulnerable Passwords of 8+ Characters ===== */
  protected Map<String, Object> createRuleResultDetailParameters(final String word){
    final Map<String, Object> blacklisted = new LinkedHashMap<>();
    blacklisted.put("password", word);
    blacklisted.put("12345678", word);
    blacklisted.put("11111111", word);
    blacklisted.put("baseball", word);
    blacklisted.put("football", word);
    blacklisted.put("jennifer", word);
    blacklisted.put("superman", word);
    blacklisted.put("trustno1", word);
    blacklisted.put("michelle", word);
    blacklisted.put("starwars", word);
    blacklisted.put("computer", word);
    blacklisted.put("corvette", word);
    blacklisted.put("princess", word);
    blacklisted.put("iloveyou", word);
    blacklisted.put("maverick", word);
    blacklisted.put("samantha", word);
    blacklisted.put("steelers", word);
    blacklisted.put("whatever", word);
    blacklisted.put("hardcore", word);
    blacklisted.put("internet", word);
    blacklisted.put("mercedes", word);
    blacklisted.put("bigdaddy", word);
    return blacklisted;
  }

  protected abstract String doWordSearch(String text);

  @Override
  public String toString(){
    return String.format(
        "%s@%h::dictionary=%s,",
        getClass().getName(),
        hashCode(),
        dictionary);
  }
}