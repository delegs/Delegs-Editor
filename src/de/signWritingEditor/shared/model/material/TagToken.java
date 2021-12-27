package de.signWritingEditor.shared.model.material;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Id;

public class TagToken extends TextbasedToken {

    private static final long serialVersionUID = 1L;
    private int width;
    private int height;
    private boolean lockedLayout;
    private boolean lockedContent;
    private ArrayList<String> itemList;
    private ArrayList<String> selectedItemList;
    private String description;
    private int inputWidth_PX;
    private int descriptionWidth_PX;

    /**
     * @deprecated only for serialization
     */
    @Deprecated
    public TagToken() {
    }

    public TagToken(Id id, ReadOnlyTextbasedTokenStyle textbasedTokenStyle) {
        this(id, textbasedTokenStyle, false, false, null, null, "");
    }

    public TagToken(Id id, ReadOnlyTextbasedTokenStyle textbasedTokenStyle, boolean lockedLayout, boolean lockedContent,
                    ArrayList<String> itemList, ArrayList<String> selectedItemList) {
        this(id, textbasedTokenStyle, lockedLayout, lockedContent, itemList, selectedItemList, "");
    }

    // TODO lockedLayout und lockedContent müssen nicht im Constructor übergeben
    // werden.
    @SuppressWarnings("deprecation")
    public TagToken(Id id, ReadOnlyTextbasedTokenStyle textbasedTokenStyle, boolean lockedLayout, boolean lockedContent,
                    ArrayList<String> itemList, ArrayList<String> selectedItemList, String description) {
        super(id, textbasedTokenStyle);
        this.width = 320;
        this.lockedLayout = lockedLayout;
        this.lockedContent = lockedContent;
        this.itemList = itemList;
        this.selectedItemList = selectedItemList;
        this.description = description;
        this.height = 20;
    }

    @Override
    public void lockLayout(boolean isLockedLayout) {
        lockedLayout = isLockedLayout;
    }

    @Override
    public boolean isLayoutLocked() {
        return lockedLayout;
    }

    @Override
    public void lockContent(boolean isLockedContent) {
        lockedContent = isLockedContent;

    }

    @Override
    public boolean isContentLocked() {
        return lockedContent;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Color getBackgroundColor() {
        return super.getTextBackgroundColor();
    }

    @Override
    public void setBackgroundColor(Color backgroundColor) {
        TextbasedTokenStyle style = (TextbasedTokenStyle) super.getStyle();
        style.setTextBackgroundColor(backgroundColor);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public ArrayList<String> getItemList() {
        return itemList;
    }

    public String getItemListString() {
        String result = "";
        if (itemList.size() > 0) {
            result = itemList.get(0);
            for (int index = 1; index < itemList.size(); index++) {
                result = result + "," + itemList.get(index);
            }
        }
        return result;
    }

    public ArrayList<String> getSelectedItemList() {
        return selectedItemList;
    }

    public String getSelectedItemString() {
        String result = "";
        if (selectedItemList.size() > 0) {
            result = selectedItemList.get(0);
            for (int index = 1; index < selectedItemList.size(); index++) {
                result = result + "," + selectedItemList.get(index);
            }
        }
        return result;
    }

    public void setItemList(ArrayList<String> itemList) {
        this.itemList = itemList;
    }

    public void setSelectedItemList(ArrayList<String> selectedItemList) {
        if (!lockedContent) {
            this.selectedItemList = selectedItemList;
        }
    }

    public void selectWord(String selectedWord) {
        if (!selectedItemList.contains(selectedWord)) {
            selectedItemList.add(selectedWord);
        }
    }

    @Override
    public String getText() {
        return getSelectedItemString();
    }

    @Override
    public void setText(String text) {
    }

    public void deselectWord(String word) {
        selectedItemList.remove(word);
    }

    public void setInputWidth(int inputWidth) {
        this.inputWidth_PX = inputWidth;
    }

    public void setDescriptionWidth(int descriptionWidth) {
        this.descriptionWidth_PX = descriptionWidth;
    }

    public int getDescriptionWidth_PX() {
        return descriptionWidth_PX;
    }

    public int getInputWidth_PX() {
        return inputWidth_PX;
    }

    public TextbasedTokenStyle getTokenStyle() {
        return (TextbasedTokenStyle) super.getStyle();
    }

    public void setFontColor(Color fontColor) {
        TextbasedTokenStyle style = getTokenStyle();
        style.setFontColor(fontColor);
    }

    public void resetItems() {
        itemList.addAll(selectedItemList);
        selectedItemList.clear();
        Collections.sort(itemList);
    }

    public void sortItems()  {
        Collections.sort(itemList);
        Collections.sort(selectedItemList);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int newHeight) {
        this.height = newHeight;
    }

    @Override
    public long contentHashCode() {
        return Objects.hash(super.contentHashCode(), description, descriptionWidth_PX, height, inputWidth_PX, itemList,
                lockedContent, lockedLayout, selectedItemList, width);
    }
}
