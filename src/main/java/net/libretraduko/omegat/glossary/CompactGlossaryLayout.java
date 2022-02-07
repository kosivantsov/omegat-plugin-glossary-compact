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

package net.libretraduko.omegat.glossary;

import org.omegat.gui.glossary.GlossaryRenderers;

/**
 * Compact Glossary Layout
 * @author Kos Ivantsov (based on the plugin skeleton by Hiroshi Miura) 
 */

public class CompactGlossaryLayout {

    //loader
    public static void loadPlugins() {
        GlossaryRenderers.addGlossaryRenderer(new Compact1a());
        GlossaryRenderers.addGlossaryRenderer(new Compact1b());
        GlossaryRenderers.addGlossaryRenderer(new Compact2a());
        GlossaryRenderers.addGlossaryRenderer(new Compact2b());
    }
    //unloader
    public static void unloadPlugins() {
    }
}
