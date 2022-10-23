import React from "react";
const TagsInput = props => {
    const [tags, setTags] = React.useState([]);
    const addTags = event => {
        if (event.key === "Enter" && event.target.value !== "") {
            setTags([...tags, event.target.value]);
            props.selectedTags([...tags, event.target.value]);
            event.target.value = "";
        }
    };
    const removeTags = index => {
        setTags([...tags.filter(tag => tags.indexOf(tag) !== index)]);
    };
    return (
        <div className="tags-input">
            <div className="d-flex flex-row bd-highlight mb-3 flex-wrap"> 
                {tags.map((tag, index) => (
                    <div  key={index} Style="margin:5px; background-color: #74b3a3; padding:5px;color:white">
                    <span >{tag}</span>
                   
                    <button type="button" Style="background-color: transparent;border:none;color:white;" className="close" aria-label="Close" onClick={() => removeTags(index)}>
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                ))}
            </div>
            <input placeholder="Press enter to add tags"className="form-control" id="exampleFormControlTextarea1"type="text" onKeyUp={event => addTags(event)} rows="3"/>
            
            
            
        </div>
    );
};
export default TagsInput;