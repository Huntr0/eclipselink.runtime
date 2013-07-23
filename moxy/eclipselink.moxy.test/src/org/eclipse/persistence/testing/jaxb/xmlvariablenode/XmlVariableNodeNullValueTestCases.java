/*******************************************************************************
 * Copyright (c) 1998, 2012 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Denise Smith - May 2013
 ******************************************************************************/ 
package org.eclipse.persistence.testing.jaxb.xmlvariablenode;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.exceptions.XMLMarshalException;
import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.testing.jaxb.JAXBWithJSONTestCases;

public class XmlVariableNodeNullValueTestCases extends JAXBWithJSONTestCases{
	protected final static String XML_RESOURCE = "org/eclipse/persistence/testing/jaxb/xmlvariablenode/rootNull.xml";
	protected final static String JSON_RESOURCE = "org/eclipse/persistence/testing/jaxb/xmlvariablenode/rootNull.json";
	
	public XmlVariableNodeNullValueTestCases(String name) throws Exception {
		super(name);
		setControlDocument(XML_RESOURCE);
	    setControlJSON(JSON_RESOURCE);
	    setClasses(new Class[]{Root.class});
	}
	
	public boolean isUnmarshalTest(){
        return false;
    }
	
	@Override
	protected Object getControlObject() {
		Root r = new Root();
		r.name = "theRootName";
		r.things = new ArrayList<Thing>();
		Thing thing1 = new Thing();
		thing1.thingName = null;
		thing1.thingValue = "thingavalue";
		
		Thing thing2 = new Thing();
		thing2.thingName = "thingb";
		thing2.thingValue = "thingbvalue";
		
		Thing thing3 = new Thing();
		thing3.thingName = "thingc";
		thing3.thingValue = "thingcvalue";
		r.things.add(thing1);
		r.things.add(thing2);
		r.things.add(thing3);
		return r;
	}

	public void objectToXMLStringWriter(Object objectToWrite) throws Exception {
		try{
     		super.objectToXMLStringWriter(objectToWrite);
		}catch(JAXBException e){
			Throwable nested = e.getLinkedException();
			assertTrue(nested instanceof XMLMarshalException);
			assertEquals(XMLMarshalException.NULL_VALUE_NOT_ALLOWED_FOR_VARIABLE,((XMLMarshalException)nested).getErrorCode());
			return;
		}
		fail("An XMLMarshalException should have occurred");
	}
	
    public void testJSONMarshalToOutputStream() throws Exception{
    	try{
     		super.testJSONMarshalToOutputStream();
		}catch(JAXBException e){
			if(verifyException(e)){
		    	return;
		    }
		}
		fail("An XMLMarshalException should have occurred");
    }
    
    public void testJSONMarshalToBuilderResult() throws Exception{
        try{
            super.testJSONMarshalToBuilderResult();
        }catch(JAXBException e){
            if(verifyException(e)){
                return;
            }
        }
        fail("An XMLMarshalException should have occurred");
    }
    
    public void testJSONMarshalToStringWriter_FORMATTED() throws Exception{
    	try{
     		super.testJSONMarshalToStringWriter_FORMATTED();
		}catch(JAXBException e){
			if(verifyException(e)){
		    	return;
		    }
		}
		fail("An XMLMarshalException should have occurred");
    }
    
    public void testJSONMarshalToOutputStream_FORMATTED() throws Exception{
    	try{
     		super.testJSONMarshalToOutputStream_FORMATTED();
		}catch(JAXBException e){
			if(verifyException(e)){
		    	return;
		    }
		}
		fail("An XMLMarshalException should have occurred");
    }
    
    public void testJSONMarshalToStringWriter() throws Exception{
    	try{
     		super.testJSONMarshalToStringWriter();
		}catch(JAXBException e){
			if(verifyException(e)){
		    	return;
		    }
		}
		fail("An XMLMarshalException should have occurred");
    }
    
    public void testObjectToOutputStream() throws Exception {
    	try{
     		super.testObjectToOutputStream();
		}catch(JAXBException e){
			if(verifyException(e)){
		    	return;
		    }
		}
		fail("An XMLMarshalException should have occurred");
    }
    
    private boolean verifyException(JAXBException e){
    	Throwable nested = e.getLinkedException();
		assertTrue(nested instanceof XMLMarshalException);
		if(((XMLMarshalException)nested).getErrorCode() == XMLMarshalException.NULL_VALUE_NOT_ALLOWED_FOR_VARIABLE){
			return true;
		}
		if(((XMLMarshalException)nested).getErrorCode() == XMLMarshalException.MARSHAL_EXCEPTION){
			Throwable internalException = ((XMLMarshalException)nested).getInternalException(); 
			assertTrue(internalException instanceof XMLMarshalException);
			if(((XMLMarshalException)internalException).getErrorCode() == XMLMarshalException.NULL_VALUE_NOT_ALLOWED_FOR_VARIABLE){
				return true;
			}
		}
		return false;
    }
    public void testObjectToOutputStreamASCIIEncoding() throws Exception {
    	try{
     		super.testObjectToOutputStreamASCIIEncoding();
		}catch(JAXBException e){			
		    if(verifyException(e)){
		    	return;
		    }
		}
		fail("An XMLMarshalException should have occurred");
   
    }
    
    public void testObjectToXMLDocument() throws Exception {
    	try{
     		super.testObjectToXMLDocument();
		}catch(JAXBException e){
			if(verifyException(e)){
		    	return;
		    }
		}
		fail("An XMLMarshalException should have occurred");
   
    }

    public void testObjectToXMLStreamWriter() throws Exception {
    	try{
     		super.testObjectToXMLStreamWriter();
		}catch(JAXBException e){
			if(verifyException(e)){
		    	return;
		    }
		}
		fail("An XMLMarshalException should have occurred");
   
    }
    
    public void testObjectToXMLStreamWriterRecord() throws Exception {
    	try{
     		super.testObjectToXMLStreamWriterRecord();
		}catch(JAXBException e){
			if(verifyException(e)){
		    	return;
		    }
		}
		fail("An XMLMarshalException should have occurred");
   
    }
    
    public void testObjectToXMLEventWriter() throws Exception {
    	try{
     		super.testObjectToXMLEventWriter();
		}catch(JAXBException e){
			if(verifyException(e)){
		    	return;
		    }
		}
		fail("An XMLMarshalException should have occurred");
   
    }
    public void testObjectToContentHandler() throws Exception {
    	try{
     		super.testObjectToContentHandler();
		}catch(JAXBException e){
			if(verifyException(e)){
		    	return;
		    }
		}
		fail("An XMLMarshalException should have occurred");
   
    }    
}