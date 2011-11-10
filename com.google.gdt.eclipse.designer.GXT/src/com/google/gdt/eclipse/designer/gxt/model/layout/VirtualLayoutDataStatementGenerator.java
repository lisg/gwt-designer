/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.google.gdt.eclipse.designer.gxt.model.layout;

import com.google.common.collect.ImmutableList;

import org.eclipse.wb.core.model.JavaInfo;
import org.eclipse.wb.core.model.association.Association;
import org.eclipse.wb.internal.core.model.generation.statement.AbstractInsideStatementGenerator;
import org.eclipse.wb.internal.core.model.generation.statement.StatementGenerator;
import org.eclipse.wb.internal.core.utils.ast.StatementTarget;

import org.eclipse.jdt.core.dom.Block;

/**
 * {@link StatementGenerator} for virtual {@link LayoutDataInfo}.
 * 
 * @author scheglov_ke
 * @coverage ExtGWT.model.layout
 */
public final class VirtualLayoutDataStatementGenerator extends AbstractInsideStatementGenerator {
  public static final StatementGenerator INSTANCE = new VirtualLayoutDataStatementGenerator();

  ////////////////////////////////////////////////////////////////////////////
  //
  // StatementGenerator
  //
  ////////////////////////////////////////////////////////////////////////////
  @Override
  public void add(JavaInfo child, StatementTarget target, Association association) throws Exception {
    // prepare block
    Block block = (Block) child.getEditor().addStatement(ImmutableList.of("{", "}"), target);
    // add statements in block
    target = new StatementTarget(block, true);
    add(child, target, null, association);
  }
}