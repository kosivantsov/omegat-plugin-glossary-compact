/**************************************************************************
 OmegaT - Computer Assisted Translation (CAT) tool
          with fuzzy matching, translation memory, keyword search,
          glossaries, and translation leveraging into updated projects.

 Copyright (C) 2019 Thomas Cordonnier
               2022 Hiroshi Miura
               Home page: http://www.omegat.org/
               Support center: https://omegat.org/support

 This file is part of OmegaT.

 OmegaT is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 OmegaT is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **************************************************************************/

package net.libretraduko.omegat;

import org.omegat.gui.glossary.DefaultGlossaryRenderer;
import org.omegat.gui.glossary.GlossaryEntry;
import org.omegat.gui.glossary.GlossaryRenderers;
import org.omegat.gui.glossary.IGlossaryRenderer;
import org.omegat.util.gui.TooltipAttribute;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ResourceBundle;

/**
 * Compact Glossary Layout
 * @author Kos Ivantsov (based on the plugin skeleton by Hiroshi Miura) 
 */
public class CompactGlossaryLayout implements IGlossaryRenderer {

    //L10n resource
    protected static final ResourceBundle res = ResourceBundle.getBundle("CompactGlossaryLayout", Locale.getDefault());

    //loader
    public static void loadPlugins() {
        GlossaryRenderers.addGlossaryRenderer(new CompactGlossaryLayout());
    }
    //unloader
    public static void unloadPlugins() {
    }

    @Override
    public String getName() {
        return res.getString("name");
    }

    @Override
    public String getId() {
        return getClass().getCanonicalName();
    }

    @Override
    public void render(final GlossaryEntry entry, final IRenderTarget<?> trg) {
        trg.append(entry.getSrcText(), SOURCE_ATTRIBUTES);
        trg.append(": ");

        String[] targets = entry.getLocTerms(false);
        String[] comments = entry.getComments();
        boolean[] priorities = entry.getPriorities();
        String[] origins = entry.getOrigins(false);

        for (int i = 0; i < targets.length; i++) {
            if (i == 0 || (!targets[i].equals(targets[i - 1]))) {
                SimpleAttributeSet attrs = new SimpleAttributeSet(TARGET_ATTRIBUTES);
                if (priorities[i]) {
                    StyleConstants.setBold(attrs, true);
                }
                attrs.addAttribute(TooltipAttribute.ATTRIBUTE_KEY, new TooltipAttribute(origins[i]));
                trg.append(targets[i], attrs);
                if (!comments[i].equals("")) {
                    trg.append(" [" + comments[i] + "]", NOTES_ATTRIBUTES);
                }
                if (i < targets.length - 1) {
                    trg.append(" | ", null);
                }
            }
        }
    }

    static class CustomDocTarget implements IRenderTarget<Void> {
        CustomDocTarget(StyledDocument doc) {
            this.doc = doc;
        }

        private final StyledDocument doc;

        @Override
        public void append(String str) {
            append(str, null);
        }

        @Override
        public void append(String str, AttributeSet attr) {
            try {
                doc.insertString(doc.getLength(), str, attr);
            } catch (BadLocationException e) {
                // Should never happen since we only insert at end
                Logger.getLogger(DefaultGlossaryRenderer.class.getName()).log(Level.SEVERE,
                        e.getLocalizedMessage(), e);
            }
        }

        @Override
        public Void get() {
            return null;
        }
    }

    @Override
    public void render(GlossaryEntry entry, StyledDocument doc) {
        CustomDocTarget trg = new CustomDocTarget(doc);
        render(entry, trg);
        trg.append("\n");
    }
}
