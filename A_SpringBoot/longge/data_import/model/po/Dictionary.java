package cn.com.geovis.data_import.data_import.model.po;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="dictionary")
public class Dictionary implements Serializable{

	private static final long serialVersionUID = -3845016049487057480L;
	
	@Id
	@SequenceGenerator(name="Dictionary_Generator",sequenceName="Dictionary_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Dictionary_Generator")
	private Long id;
	
	@Column
	@NotEmpty(message="key值不能为空")
	private String key;
	
	@Column
	@NotEmpty(message="value值不能为空")
	private String value;
	
	@Column
	private int sort = 0;
	
	@Column
	private String description;
	
	@ManyToOne
	@JoinColumn(name="parent_id")
	@JsonIgnore
	private Dictionary parent;
	
	@OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="parent_id")
	private List<Dictionary> dictionarys;
	
	public Dictionary(){
	}
	
	public Dictionary(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public Dictionary(Dictionary dictionary){
		this.id = dictionary.getId();
		this.key = dictionary.getKey();
		this.value = dictionary.getValue();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public Dictionary getParent() {
		return parent;
	}

	public void setParent(Dictionary parent) {
		this.parent = parent;
	}

	public List<Dictionary> getDictionarys() {
		return dictionarys;
	}

	public void setDictionarys(List<Dictionary> dictionarys) {
		this.dictionarys = dictionarys;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
