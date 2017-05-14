package br.com.redefatec.converter;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.redefatec.model.Materia;
import br.com.redefatec.service.MateriaService;



@FacesConverter("materiaConverter")
public class MateriaConverter implements Converter{
	@ManagedProperty(value="#{materiaService}")
	private MateriaService materiaService;
	


	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) throws ConverterException {
		// TODO Auto-generated method stub
        if(value != null && value.trim().length() > 0) {
            try {
            	System.out.println("materi converter"+materiaService);
                Materia materia = (Materia)uic.getAttributes().get(value);
                return materia;
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) throws ConverterException {
		// TODO Auto-generated method stub
		 if(object != null) {
	            return String.valueOf(((Materia) object).getId());
	        }
	        else {
	            return null;
	        }
	}

}
