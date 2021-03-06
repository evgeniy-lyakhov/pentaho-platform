/*
 * This program is free software; you can redistribute it and/or modify it under the
 * terms of the GNU General Public License, version 2 as published by the Free Software
 * Foundation.
 *
 * You should have received a copy of the GNU General Public License along with this
 * program; if not, you can obtain a copy at http://www.gnu.org/licenses/gpl-2.0.html
 * or from the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 *
 * Copyright 2006 - 2013 Pentaho Corporation.  All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.07.25 at 11:25:28 AM EDT 
//

package org.pentaho.platform.plugin.services.importexport.exportManifest.bindings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Java class for ExportManifestProperty complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportManifestProperty">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="EntityMetaData" type="{http://www.pentaho.com/schema/}EntityMetaData"/>
 *         &lt;element name="EntityAcl" type="{http://www.pentaho.com/schema/}EntityAcl"/>
 *         &lt;element name="CustomProperty" type="{http://www.pentaho.com/schema/}CustomProperty"
 *         maxOccurs="unbounded"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "ExportManifestProperty", propOrder = { "entityMetaData", "entityAcl", "customProperty" } )
public class ExportManifestProperty {

  @XmlElement( name = "EntityMetaData" )
  protected EntityMetaData entityMetaData;
  @XmlElement( name = "EntityAcl" )
  protected EntityAcl entityAcl;
  @XmlElement( name = "CustomProperty" )
  protected List<CustomProperty> customProperty;

  /**
   * Gets the value of the entityMetaData property.
   * 
   * @return possible object is {@link EntityMetaData }
   * 
   */
  public EntityMetaData getEntityMetaData() {
    return entityMetaData;
  }

  /**
   * Sets the value of the entityMetaData property.
   * 
   * @param value
   *          allowed object is {@link EntityMetaData }
   * 
   */
  public void setEntityMetaData( EntityMetaData value ) {
    this.entityMetaData = value;
  }

  /**
   * Gets the value of the entityAcl property.
   * 
   * @return possible object is {@link EntityAcl }
   * 
   */
  public EntityAcl getEntityAcl() {
    return entityAcl;
  }

  /**
   * Sets the value of the entityAcl property.
   * 
   * @param value
   *          allowed object is {@link EntityAcl }
   * 
   */
  public void setEntityAcl( EntityAcl value ) {
    this.entityAcl = value;
  }

  /**
   * Gets the value of the customProperty property.
   * 
   * <p>
   * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
   * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
   * the customProperty property.
   * 
   * <p>
   * For example, to add a new item, do as follows:
   * 
   * <pre>
   * getCustomProperty().add( newItem );
   * </pre>
   * 
   * 
   * <p>
   * Objects of the following type(s) are allowed in the list {@link CustomProperty }
   * 
   * 
   */
  public List<CustomProperty> getCustomProperty() {
    if ( customProperty == null ) {
      customProperty = new ArrayList<CustomProperty>();
    }
    return this.customProperty;
  }

}
