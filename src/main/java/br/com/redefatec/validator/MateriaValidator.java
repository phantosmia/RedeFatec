package br.com.redefatec.validator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@SessionScoped
@FacesValidator("br.com.redefatec.validator.MateriaValidator")
public class MateriaValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		System.out.println(value);
		if(value.toString().isEmpty() || value.equals(null))
		{
			System.out.println("depois do if"+value);
			FacesMessage msg = new FacesMessage("Campo Vazio","Campo não pode está vazio!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}

}
