package br.com.redefatec.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.redefatec.model.Professor;
import br.com.redefatec.service.ProfessorService;

@FacesConverter("professorConverter")
public class ProfessorConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) throws ConverterException {
		// TODO Auto-generated method stub
        if(value != null && value.trim().length() > 0) {
            try {
                
                return (Professor)uic.getAttributes().get(value);
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
	            return String.valueOf(((Professor) object).getId());
	        }
	        else {
	            return null;
	        }
	}

}
