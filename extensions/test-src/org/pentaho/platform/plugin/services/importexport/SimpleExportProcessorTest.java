/*!
 * This program is free software; you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License, version 2.1 as published by the Free Software
 * Foundation.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * program; if not, you can obtain a copy at http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 * or from the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * Copyright (c) 2002-2013 Pentaho Corporation..  All rights reserved.
 */

package org.pentaho.platform.plugin.services.importexport;
/*
 * This program is free software; you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License, version 2.1 as published by the Free Software
 * Foundation.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * program; if not, you can obtain a copy at http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 * or from the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * Copyright 2013 Pentaho Corporation.  All rights reserved.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.pentaho.platform.api.repository2.unified.IUnifiedRepository;
import org.pentaho.platform.api.repository2.unified.RepositoryFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class SimpleExportProcessorTest {
  private static final String PATH = "/temp";
  private static final String PARENT_PATH = "/";
  private static final int READ_AMOUNT_OF_BYTES = 10;
  private static final int EOF = -1;

  private SimpleExportProcessor simpleExportProcessor;
  private IUnifiedRepository unifiedRepository;
  private RepositoryFile repositoryFile;
  private DefaultExportHandler defaultExportHandler;
  private InputStream inputStream;

  @Rule
  public ExpectedException expectedException = ExpectedException.none();


  @Before
  public void setUp() throws Exception {
    unifiedRepository = mock( IUnifiedRepository.class );
    defaultExportHandler = mock( DefaultExportHandler.class );
    repositoryFile = mock( RepositoryFile.class );
    inputStream = mock( InputStream.class );
    simpleExportProcessor = new SimpleExportProcessor( PATH, unifiedRepository );

    when( defaultExportHandler.doExport( repositoryFile, PARENT_PATH ) ).thenReturn( inputStream );
    doNothing().when( inputStream ).close();
    when( inputStream.read( any( byte[].class ) ) ).thenReturn( READ_AMOUNT_OF_BYTES, EOF );
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testPerformExport() throws Exception {
    simpleExportProcessor.addExportHandler( defaultExportHandler );
    File resultFile = simpleExportProcessor.performExport( repositoryFile );
    assertNotNull( resultFile );
  }

  @Test
  public void testPerformExportNullRepositoryFile() throws Exception {
    simpleExportProcessor.addExportHandler( defaultExportHandler );
    expectedException.expect( FileNotFoundException.class );
    simpleExportProcessor.performExport( null );
  }

  @Test
  public void testExportDirectory() throws Exception {
    simpleExportProcessor.addExportHandler( defaultExportHandler );
    expectedException.expect( UnsupportedOperationException.class );
    SimpleExportProcessor simpleExportProcessor = new SimpleExportProcessor( PATH, unifiedRepository );
    simpleExportProcessor.exportDirectory( repositoryFile, mock( OutputStream.class ), PATH );
  }

  @Test
  public void testExportFile() throws Exception {
    simpleExportProcessor.addExportHandler( defaultExportHandler );
    simpleExportProcessor.exportFile( repositoryFile, mock( OutputStream.class ), PARENT_PATH );
    verify( defaultExportHandler, atLeastOnce() ).doExport( repositoryFile, PARENT_PATH );
    verify( inputStream, times( 1 ) ).close();
  }

  @Test
  public void testExportFileEmptyHandlerList() throws Exception {
    simpleExportProcessor.exportFile( repositoryFile, mock( OutputStream.class ), PARENT_PATH );
    verify( defaultExportHandler, times( 0 ) ).doExport( repositoryFile, PARENT_PATH );
    verify( inputStream, times( 0 ) ).close();

  }


}
